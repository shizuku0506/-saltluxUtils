package com.shizuku.httpclient;

public class HeaderVO
{
	private String accept;

	private String acceptEncoding;

	private String connection;

	private String contentType;

	private String host;

	private String userAgent;

	public String getAccept()
	{
		return accept;
	}

	public void setAccept(String accept)
	{
		this.accept = accept;
	}

	public String getAcceptEncoding()
	{
		return acceptEncoding;
	}

	public void setAcceptEncoding(String acceptEncoding)
	{
		this.acceptEncoding = acceptEncoding;
	}

	public String getConnection()
	{
		return connection;
	}

	public void setConnection(String connection)
	{
		this.connection = connection;
	}

	public String getContentType()
	{
		return contentType;
	}

	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	public String getHost()
	{
		return host;
	}

	public void setHost(String host)
	{
		this.host = host;
	}

	public String getUserAgent()
	{
		return userAgent;
	}

	public void setUserAgent(String userAgent)
	{
		this.userAgent = userAgent;
	}
}
