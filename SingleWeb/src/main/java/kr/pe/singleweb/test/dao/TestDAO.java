package kr.pe.singleweb.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO
{
	@Autowired
	private SqlSession sqlSession;

	public Map<String, String> selectTestValue()
	{
		return sqlSession.selectMap("testSqlMapper.selectTestValue", "");
	}

	public List<Map<String, String>> selectTestValueList()
	{
		return sqlSession.selectList("testSqlMapper.selectTestValue");
	}

}
