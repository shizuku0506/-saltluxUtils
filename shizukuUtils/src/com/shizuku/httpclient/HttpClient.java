package com.shizuku.httpclient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * HttpClient 설명
 *
 * @author 박정선 e-mail: souler2585@gmail.com
 * @since 2015. 5. 13.
 */
public class HttpClient
{
	public static final String TARGET_URL = "targetURL";

	@SuppressWarnings("unchecked")
	public String getRestPostValue(HeaderVO vo, Map<String, String> param)
	{

		CloseableHttpResponse response = null;
		String resultStr = StringUtils.EMPTY;

		HttpPost httppost = new HttpPost(param.get(TARGET_URL));

		Header[] headers = new Header[6];
		if (isCompletedHeaderVO(vo) == true)
		{
			headers[0] = new BasicHeader("Accept", vo.getAccept());
			headers[1] = new BasicHeader("Accept-Encoding", vo.getAcceptEncoding());
			headers[2] = new BasicHeader("Connection", vo.getConnection());
			headers[3] = new BasicHeader("Content-Type", vo.getContentType());
			headers[4] = new BasicHeader("Host", vo.getHost());
			headers[5] = new BasicHeader("User-Agent", vo.getUserAgent());
			httppost.setHeaders(headers);
		}

		ArrayList<Object> postParameters = new ArrayList<Object>();
		Iterator<String> it = param.keySet().iterator();

		while (it.hasNext())
		{
			String s = it.next();

			if (StringUtils.equals(s, TARGET_URL))
			{
				continue;
			}
			postParameters.add(new BasicNameValuePair(s, param.get(s)));
		}

		try
		{
			// TODO MAP
			httppost.setEntity(new UrlEncodedFormEntity((List<? extends NameValuePair>) postParameters));
			// httppost.setEntity(new ByteArrayEntity(src.getBytes(HTTP.UTF_8)));
		} catch (Exception e)
		{
			System.out.println("HttpClient Error : setEntity Error  >> " + e.getMessage());
			return StringUtils.EMPTY;
		}
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try
		{
			response = httpclient.execute(httppost);
		} catch (Exception e)
		{
			System.out.println("HttpClient Error : http execute Error >> " + e.getMessage());
			return StringUtils.EMPTY;
		}

		if ((StringUtils.indexOf(response.getStatusLine().toString(), "200") > 1) == false)
		{
			System.out.println("HttpClient Error : http response not 200  >> " + response.getStatusLine().toString());
			return StringUtils.EMPTY;
		}

		try
		{
			resultStr = this.makeResultValue(response.getEntity());
		} catch (Exception e)
		{
			System.out.println("HttpClient Error : result String Parse Error >> " + e.getMessage());
			return StringUtils.EMPTY;
		}
		return resultStr;
	}

	public String getRestGetValue(Map<String, String> param)
	{
		StringBuilder sb = new StringBuilder();
		int cnt = 0;

		Set<String> keys = param.keySet();
		Iterator<String> it = keys.iterator();

		sb.append(param.get(TARGET_URL));

		while (it.hasNext())
		{
			String key = it.next();

			if (StringUtils.equals(TARGET_URL, key))
			{
				continue;
			}

			if (cnt == 0)
			{
				sb.append("?");
			} else
			{
				sb.append("&");
			}

			sb.append(key);
			sb.append("=");
			if (StringUtils.isNotEmpty(param.get(key)))
			{
				try
				{
					sb.append(URLEncoder.encode(param.get(key), HTTP.UTF_8));
				} catch (UnsupportedEncodingException e)
				{
					e.printStackTrace();
				}
			}
			cnt++;
		}

		CloseableHttpResponse response = null;
		String resultStr = StringUtils.EMPTY;

		HttpGet httpget = new HttpGet(sb.toString());

		CloseableHttpClient httpclient = HttpClients.createDefault();

		try
		{
			response = httpclient.execute(httpget);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if ((StringUtils.indexOf(response.getStatusLine().toString(), "200") > 1) == false)
		{
			System.out.println("HttpClient Error : http response not 200  >> " + response.getStatusLine().toString());
			return StringUtils.EMPTY;
		}

		try
		{
			resultStr = this.makeResultValue(response.getEntity());
		} catch (Exception e)
		{
			System.out.println("HttpClient Error : result String Parse Error >> " + e.getMessage());
			return StringUtils.EMPTY;
		}

		return resultStr;
	}

	@SuppressWarnings("unused")
	private String makeHeaderInfo(HttpResponse httpResponse)
	{
		StringBuilder headerSb = new StringBuilder();
		Header[] headers = httpResponse.getAllHeaders();
		for (int i = 0; i < headers.length; i++)
		{
			headerSb.append(headers[i] + "\n");
		}
		return headerSb.toString();
	}

	private String makeResultValue(HttpEntity entity)
	{
		if (entity != null)
		{
			try
			{
				return EntityUtils.toString(entity, "UTF-8");
			} catch (Exception e)
			{
				return StringUtils.EMPTY;
			}
		} else
		{
			return StringUtils.EMPTY;
		}
	}

	private boolean isCompletedHeaderVO(HeaderVO vo)
	{
		if (vo == null)
		{
			return false;
		}
		if (StringUtils.isBlank(vo.getAccept()) == true)
		{
			return false;
		}
		if (StringUtils.isBlank(vo.getAcceptEncoding()) == true)
		{
			return false;
		}
		if (StringUtils.isBlank(vo.getConnection()) == true)
		{
			return false;
		}
		if (StringUtils.isBlank(vo.getContentType()) == true)
		{
			return false;
		}
		if (StringUtils.isBlank(vo.getHost()) == true)
		{
			return false;
		}
		if (StringUtils.isBlank(vo.getUserAgent()) == true)
		{
			return false;
		}
		return true;
	}
}
