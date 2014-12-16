/*
 * 라이센스 위치
 */
package kr.pe.singleweb.cmm.usr.service;

import kr.pe.singleweb.cmm.usr.dao.UserDAO;
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
	private UserDAO userDAO;

	public UserVO getUserSession()
	{
		UserVO userVO =  new UserVO();
		
		// TODO
		try{
			userVO  = userDAO.getUserInfo();
		}catch(Exception e ){
		}

		if (StringUtils.isBlank(userVO.getUserId()) == true)
		{
			userVO.setUserId("guest");
			userVO.setUserName("게스트");
		}

		return userVO;
	};
}
