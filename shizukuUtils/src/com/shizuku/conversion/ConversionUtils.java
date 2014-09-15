package com.shizuku.conversion;

import org.apache.commons.lang.StringUtils;

public class ConversionUtils
{

	public static void main(String[] args)
	{
		String eng = "gksrmfdl wkfskdhsi??";
		String kor = "한글이 잘나오고있을거야....";

		eng = "f";
		kor = "ㅋㅌㅊㅍ";

		ConversionUtils cu = new ConversionUtils();

		System.out.println("@@" + cu.converisonEngToKor(eng));
		// System.out.println("@@" + cu.converisonKorToEng(kor));
	}

	public String checkFirstCharecterType(String str)
	{
		String typeStr = StringUtils.EMPTY;

		if (StringUtils.isBlank(str))
		{
			return typeStr;
		}

		for (int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			// 한글 ( 한글자 || 자음 , 모음 )
			if ((0xAC00 <= ch && ch <= 0xD7A3) || (0x3131 <= ch && ch <= 0x318E))
			{
				typeStr = "KOR";
				break;
			} else if ((0x61 <= ch && ch <= 0x7A) || (0x41 <= ch && ch <= 0x5A))
			{
				// 영어
				typeStr = "ENG";
				break;
			} else if (0x30 <= ch && ch <= 0x39)
			{
				// 숫자 : 체크 타입이 더 필요시 넣어준다 skip
			} else
			{
				// skip
			}
		}
		return typeStr;
	}

	public String converisonEngToKor(String eng)
	{
		String result = StringUtils.EMPTY;

		ConversionWord conversion = new ConversionWord();

		try
		{
			result = conversion.rebuildEngToKor(eng);
		} catch (Exception e)
		{
			e.getMessage();
		}
		return result;
	}

	public String converisonKorToEng(String kor)
	{
		String result = StringUtils.EMPTY;

		ConversionWord conversion = new ConversionWord();

		try
		{
			result = conversion.rebuildKorToEng(kor);
		} catch (Exception e)
		{
			e.getMessage();
		}
		return result;
	}
}
