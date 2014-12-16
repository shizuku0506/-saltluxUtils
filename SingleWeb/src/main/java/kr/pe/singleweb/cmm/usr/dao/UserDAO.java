package kr.pe.singleweb.cmm.usr.dao;

import kr.pe.singleweb.cmm.usr.model.UserVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO
{
	@Autowired
	private SqlSession sqlSession;

	public UserVO getUserInfo()
	{
		return sqlSession.selectOne("user.selectUserInfo", null);
	}

}
