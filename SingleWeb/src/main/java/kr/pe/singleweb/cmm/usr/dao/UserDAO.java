package kr.pe.singleweb.cmm.usr.dao;

import kr.pe.singleweb.cmm.usr.model.UserVO;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO
{
	@Autowired
	private SqlSession sqlSession;

	@Deprecated
	public UserVO getUserInfo(UserVO userVO)
	{
		return sqlSession.selectOne("user.selectUserInfo", null);
	}

	public int isLogin(UserVO userVO)
	{
		if (StringUtils.isBlank(userVO.getUserId()) == true)
		{
			// false 처리
			return 0;
		}
		return sqlSession.selectOne("user.countUser", userVO);
	}

}
