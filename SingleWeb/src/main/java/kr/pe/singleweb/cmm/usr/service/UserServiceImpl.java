package kr.pe.singleweb.cmm.usr.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<UserVO> getUserInfo(UserVO userVO)
	{
		List<UserVO> resultList = new ArrayList<UserVO>();
		try
		{
			resultList = userDAO.selectUserInfoList(userVO);
		} catch (Exception e)
		{
		}
		return resultList;
	}

	/**
	 * login 체크
	 *
	 * @author 박정선 e-mail: souler2585@gmail.com
	 * @since 2014. 12. 19.
	 */
	@Override
	public boolean isLogin(UserVO userVO)
	{
		boolean b = false;
		try
		{
			if (userDAO.isLogin(userVO) > 0)
			{
				b = true;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 회원가입
	 *
	 * @author 박정선 e-mail: souler2585@gmail.com
	 * @since 2014. 12. 19.
	 */
	@Override
	public boolean addUserInfo(UserVO userVO)
	{
		boolean b = false;
		try
		{
			if (userDAO.insertUserInfo(userVO) > 0)
			{
				b = true;
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

}
