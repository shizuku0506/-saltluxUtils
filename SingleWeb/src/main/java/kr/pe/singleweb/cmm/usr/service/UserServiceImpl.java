package kr.pe.singleweb.cmm.usr.service;

import kr.pe.singleweb.cmm.usr.dao.UserDAO;
import kr.pe.singleweb.cmm.usr.model.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserVO getUserInfo(UserVO userVO)
	{
		try
		{
			userVO = userDAO.getUserInfo(userVO);
		} catch (Exception e)
		{
		}
		return userVO;
	}

	@Override
	public boolean isLogin(UserVO userVO)
	{
		boolean b = false;
		int cnt = 0;
		try
		{
			cnt = userDAO.isLogin(userVO);

			if (cnt > 0)
			{
				b = true;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean addUserInfo(UserVO userVO)
	{
		// TODO
		return false;
	}

}
