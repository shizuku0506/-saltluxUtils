package com.shizuku.httpclient;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class HttpClientUtils
{
	// protected final String TARGET_URL = "targetURL";

	private HttpClient httpClient;

	public HttpClientUtils()
	{
		if (httpClient == null)
		{
			httpClient = new HttpClient();
		}
	}

	public String getRestGetValue(Map<String, String> param)
	{
		if (StringUtils.isBlank(param.get(HttpClient.TARGET_URL)) == true)
		{
			return StringUtils.EMPTY;
		}
		return httpClient.getRestGetValue(param);
	}

	public String getRestPostValue(HeaderVO vo, Map<String, String> param)
	{
		if (StringUtils.isBlank(param.get(HttpClient.TARGET_URL)) == true)
		{
			return StringUtils.EMPTY;
		}
		return httpClient.getRestPostValue(vo, param);
	}

}
