package com.jspark.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 파싱하는 유틸 모음
 * 
 * @author 박정선 e-mail: jspark@saltlux.com
 * @since 2014. 5. 14.
 */
public class ParseUtils
{
	/**
	 * jsp 파싱하는 메소드
	 * 
	 * @author 박정선 e-mail: jspark@saltlux.com
	 * @since 2014. 5. 16.
	 */
	public String getJspText(File jspFile)
	{
		String jspStr = StringUtils.EMPTY;

		try
		{
			InputStream is = new FileInputStream(jspFile);
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");

			Reader in = new BufferedReader(isr);
			StringBuffer tempSb = new StringBuffer();

			int ch;

			while ((ch = in.read()) > -1)
			{
				tempSb.append((char) ch);
			}
			jspStr = tempSb.toString();
		} catch (Exception e)
		{
			e.printStackTrace();
			return StringUtils.EMPTY;
		}

		jspStr = getJspText(jspStr);

		return jspStr;
	}

	/**
	 * jsp 파싱하는 메소드
	 * 
	 * @author 박정선 e-mail: jspark@saltlux.com
	 * @since 2014. 5. 14.
	 */
	public String getJspText(String jspContent)
	{
		if (StringUtils.isBlank(jspContent))
		{
			return StringUtils.EMPTY;
		}

		boolean isSuccess = true;
		String tempStr = StringUtils.EMPTY;
		StringBuffer buffer = new StringBuffer(jspContent);

		try
		{
			while (buffer.indexOf("<%--") > -1)
			{
				int start = buffer.indexOf("<%--");
				int end = buffer.indexOf("--%>");
				buffer = buffer.delete(start, end + 4);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			isSuccess = false;
		}

		try
		{
			while (buffer.indexOf("<%") > -1)
			{
				int start = buffer.indexOf("<%");
				int end = buffer.indexOf("%>");
				buffer = buffer.delete(start, end + 2);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			isSuccess = false;
		}

		// 실패를 한번이라도 하면, 원본jsp 택스트를 리턴하도록
		if (isSuccess)
		{
			tempStr = this.getHtmlText(buffer.toString());
		} else
		{
			tempStr = jspContent;
		}

		return tempStr;
	}

	/**
	 * html 파싱하는 메소드
	 * 
	 * @author 박정선 e-mail: jspark@saltlux.com
	 * @since 2014. 5. 14.
	 */
	public String getHtmlText(String htmlContent)
	{
		if (StringUtils.isBlank(htmlContent))
		{
			return StringUtils.EMPTY;
		}

		Document doc = Jsoup.parse(htmlContent);
		htmlContent = StringUtils.trim(doc.text());

		return htmlContent;
	}

	public String getHtmlText(File htmlFile)
	{

		String tempStr = StringUtils.EMPTY;

		try
		{
			InputStream is = new FileInputStream(htmlFile);
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");

			Reader in = new BufferedReader(isr);
			StringBuffer tempSb = new StringBuffer();

			int ch;

			while ((ch = in.read()) > -1)
			{
				tempSb.append((char) ch);
			}
			tempStr = tempSb.toString();
		} catch (Exception e)
		{
			e.printStackTrace();
			tempStr = StringUtils.EMPTY;
		}

		tempStr = this.getHtmlText(tempStr);

		return tempStr;
	}
}
