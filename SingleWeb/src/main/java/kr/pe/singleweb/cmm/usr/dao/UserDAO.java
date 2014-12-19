package kr.pe.singleweb.cmm.usr.dao;

import java.util.List;

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

	public List<UserVO> selectUserInfoList(UserVO userVO)
	{
		return sqlSession.selectList("user.selectUserInfo", userVO);
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

	public int insertUserInfo(UserVO userVO)
	{
		return sqlSession.insert("user.insertUserInfo", userVO);
	}

}
