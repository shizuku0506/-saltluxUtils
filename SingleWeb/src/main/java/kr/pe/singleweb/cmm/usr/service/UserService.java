package kr.pe.singleweb.cmm.usr.service;

import kr.pe.singleweb.cmm.usr.model.UserVO;

public interface UserService
{
	public UserVO getUserInfo(UserVO userVO);
	
	public boolean isLogin(UserVO userVO);

	public boolean addUserInfo(UserVO userVO);
}
