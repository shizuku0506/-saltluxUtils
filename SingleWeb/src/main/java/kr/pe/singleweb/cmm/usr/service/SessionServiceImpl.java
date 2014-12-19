/*
 * 라이센스 위치
 */
package kr.pe.singleweb.cmm.usr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.pe.singleweb.cmm.usr.model.UserVO;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Session 과 연관된 인터페이스
 *
 * @author 박정선 e-mail: souler2585@gmail.com
 * @since 2014. 12. 15.
 */
@Service(value = "sessionService")
public class SessionServiceImpl implements SessionService
{

	@Override
	public String getSessionUserId(HttpServletRequest request, HttpServletResponse response)
	{
		String userId = StringUtils.EMPTY;
		try
		{
			HttpSession session = request.getSession();
			UserVO userVO = (UserVO) session.getAttribute("userVO");
			userId = userVO.getUserId();
		} catch (Exception e)
		{
			// skip
		}
		return userId;
	}

	@Override
	public String getSessionUserName(HttpServletRequest request, HttpServletResponse response)
	{
		String userName = StringUtils.EMPTY;
		try
		{
			HttpSession session = request.getSession();
			UserVO userVO = (UserVO) session.getAttribute("userVO");
			userName = userVO.getUserName();
		} catch (Exception e)
		{
			// skip
		}
		return userName;
	}

	@Override
	public UserVO getSessionUserInfo(HttpServletRequest request, HttpServletResponse response)
	{
		UserVO userVO = new UserVO();
		try
		{
			HttpSession session = request.getSession();
			userVO = (UserVO) session.getAttribute("userVO");
		} catch (Exception e)
		{
			// skip
		}
		return userVO;
	}
}
