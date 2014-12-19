package kr.pe.singleweb.cmm.usr.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.pe.singleweb.cmm.usr.model.UserVO;
import kr.pe.singleweb.cmm.usr.service.SessionService;
import kr.pe.singleweb.cmm.usr.service.UserService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 사용자와 관련된 컨트롤러
 *
 * @author 박정선 e-mail: souler2585@gmail.com
 * @since 2014. 12. 15.
 */
@Controller
@RequestMapping(value = "/usr")
public class UserController
{
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private SessionService sessionService;

	/**
	 * 로그인 페이지
	 *
	 * @author 박정선 e-mail: souler2585@gmail.com
	 * @since 2014. 12. 18.
	 */
	@RequestMapping(value = "login.do")
	public ModelAndView goLoginPage(ModelAndView mav, HttpServletRequest request, HttpServletResponse response)
	{
		UserVO userVO = sessionService.getSessionUserInfo(request, response);

		if (StringUtils.isBlank(userVO.getUserId()) || StringUtils.equalsIgnoreCase(userVO.getUserId(), "guest"))
		{
			mav.setViewName("/usr/login.tiles");
		} else
		{
			mav.setViewName("redirect:/index.do");
		}

		return mav;
	}

	/**
	 * 로그인
	 *
	 * @author 박정선 e-mail: souler2585@gmail.com
	 * @since 2014. 12. 18.
	 */
	@RequestMapping(value = "doLogin.do")
	@ResponseBody
	public ModelMap doLogin(@ModelAttribute UserVO userVO, HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();

		ModelMap map = new ModelMap();

		boolean isLogin = userService.isLogin(userVO);

		map.addAttribute("isLogin", isLogin);
		map.addAttribute("userVO", userVO);

		if (isLogin == true)
		{
			session.setAttribute("userVO", userVO);
		}
		return map;
	}

	/**
	 * 로그아웃
	 * 
	 * @author 박정선 e-mail: souler2585@gmail.com
	 * @since 2014. 12. 18.
	 */
	@RequestMapping(value = "doLogout.do")
	public String doLogout(@ModelAttribute UserVO userVO, HttpServletRequest request, HttpServletResponse response)
	{
		logger.debug("[doLogout]");

		HttpSession session = request.getSession();
		session.setAttribute("userVO", new UserVO());

		return "forward:/index.do";
	}

	@RequestMapping(value = "join.do")
	public ModelAndView goJoin(@ModelAttribute UserVO userVO, HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/usr/join.tiles");
		return mav;
	}

	@RequestMapping(value = "doJoin.do")
	public ModelMap doJoin(@ModelAttribute UserVO userVO, HttpServletRequest request, HttpServletResponse response)
	{
		ModelMap map = new ModelMap();
		boolean isSuccess = userService.addUserInfo(userVO);
		return map;
	}
}
