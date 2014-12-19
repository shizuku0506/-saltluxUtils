package kr.pe.singleweb.cmm.usr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.pe.singleweb.cmm.usr.model.UserVO;

public interface SessionService
{
	public String getSessionUserId(HttpServletRequest request, HttpServletResponse response);

	public String getSessionUserName(HttpServletRequest request, HttpServletResponse response);
	
	public UserVO getSessionUserInfo(HttpServletRequest request, HttpServletResponse response);
}
