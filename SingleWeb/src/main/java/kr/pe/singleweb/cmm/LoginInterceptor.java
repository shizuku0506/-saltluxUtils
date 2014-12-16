package kr.pe.singleweb.cmm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.pe.singleweb.cmm.usr.model.UserVO;
import kr.pe.singleweb.cmm.usr.service.SessionService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
	private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Autowired
	private SessionService sessionService;

	/**
	 * 1. 클라이언트의 요청을 컨트롤러에 전달 하기 전에 호출
	 * 
	 * 2. false 인 경우 intercepter 또는 controller 를 실행 시키지 않고 요청 종료
	 *
	 * @author 박정선 e-mail: souler2585@gmail.com
	 * @since 2014. 12. 15.
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception
	{
		logger.debug("[LoginInterceptor] preHandle");

		HttpSession session = request.getSession();
		UserVO userVO = new UserVO();

		if (session == null)
		{
			userVO = sessionService.getUserSession();
		} else
		{
			if (session.getAttribute("userVO") == null)
			{
				userVO = sessionService.getUserSession();
			} else
			{
				if (session.getAttribute("userVO") instanceof UserVO)
				{
					userVO = (UserVO) session.getAttribute("userVO");
					if (StringUtils.equalsIgnoreCase(userVO.getUserId(), "guest"))
					{
						userVO = sessionService.getUserSession();
					}
				} else
				{
					userVO = sessionService.getUserSession();
				}
			}
		}

		logger.debug("[current User Id ] " + userVO.getUserId());

		session.setAttribute("userVO", userVO);

		return true;
	}

	/**
	 * 1. 컨트롤러 로직 실행 된 후 호출됨
	 * 
	 * 2. 컨트롤러 실행 도중 error 발생의 경우 postHandle() 는 실행 되지 않음
	 * 
	 * 3. request 로 넘어온 데이터 가공시 많이 쓰임
	 *
	 * @author 박정선 e-mail: souler2585@gmail.com
	 * @since 2014. 12. 15.
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
					throws Exception
	{
		// TODO Auto-generated method stub

	}

	/**
	 * 1. 컨트롤러 로직 실행 된 후 호출 됨
	 * 
	 * 2. 컨트롤러 실행 도중이나 view 페이지 실행 도중 error 발생 해도 실행됨
	 *
	 * 3. 공통 Exception 처리 로직 작성시 많이 쓰임
	 *
	 * @author 박정선 e-mail: souler2585@gmail.com
	 * @since 2014. 12. 15.
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
					throws Exception
	{
		// TODO Auto-generated method stub

	}
}
