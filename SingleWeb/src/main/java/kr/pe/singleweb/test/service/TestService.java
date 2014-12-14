package kr.pe.singleweb.test.service;

import java.util.Map;

import kr.pe.singleweb.test.dao.TestDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService
{
	@Autowired
	private TestDAO testDAO;

	public Map<String, String> selectTestValue()
	{
		return testDAO.selectTestValue();
	}

}
