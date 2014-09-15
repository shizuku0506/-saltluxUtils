package com.shizuku.conversion;

public class ConversionWord
{
	// 코드타입 - 초성, 중성, 종성
	public enum CodeType
	{
		CODE_TYPE_CHOSUNG, CODE_TYPE_JONGSUNG, CODE_TYPE_JWUNGSUNG
	}

	// ㄱ ㄲ ㄴ ㄷ ㄸ ㄹ
	// ㅁ ㅂ ㅃ ㅅ ㅆ ㅇ
	// ㅈ ㅉ ㅊ ㅋ ㅌ ㅍ
	// ㅎ
	private final char[] ChoSung = { 0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145,
					0x3146, 0x3147, 0x3148, 0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };

	private final String[] ChoSungEng = { "r", "R", "s", "e", "E", "f", "a", "q", "Q", "t", "T", "d", "w", "W", "c",
					"z", "x", "v", "g" };

	// ㄱ ㄲ ㄳ ㄴ ㄵ
	// ㄶ ㄷ ㄹ ㄺ ㄻ ㄼ
	// ㄽ ㄾ ㄿ ㅀ ㅁ ㅂ
	// ㅄ ㅅ ㅆ ㅇ ㅈ ㅊ
	// ㅋ ㅌ ㅍ ㅎ
	private final char[] JongSung = { 0, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a,
					0x313b, 0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145, 0x3146, 0x3147,
					0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };

	private final String[] JongSungEng = { "", "r", "R", "rt", "s", "sw", "sg", "e", "f", "fr", "fa", "fq", "ft", "fx",
					"fv", "fg", "a", "q", "qt", "t", "T", "d", "w", "c", "z", "x", "v", "g" };

	// ㅏ ㅐ ㅑ ㅒ ㅓ ㅔ
	// ㅕ ㅖ ㅗ ㅘ ㅙ ㅚ
	// ㅛ ㅜ ㅝ ㅞ ㅟ ㅠ
	// ㅡ ㅢ ㅣ
	private final char[] JwungSung = { 0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158,
					0x3159, 0x315a, 0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160, 0x3161, 0x3162, 0x3163 };

	private final String[] JwungSungEng = { "k", "o", "i", "O", "j", "p", "u", "P", "h", "hk", "ho", "hl", "y", "n",
					"nj", "np", "nl", "b", "m", "ml", "l" };

	/**
	 * 완성되지 않은 한글의 경우 영문 변환이 제대로 되지 않는다.
	 * 
	 * 잘못된 글자인 경우에도 영문으로 변환이 가능하도록 추가적으로 처리하는 함수 글자가 초성, 중성, 종성을 구성하는
	 * 
	 * 글자 배열을 루프돌면서 같은글자가 있는지 확인한 후 해당 영문으로 변환함.
	 */
	@Deprecated
	public String convertToEnglishforSingleChar(String s)
	{
		String result = "";
		String temp = null;

		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);

			if (ch >= 0x3131 && ch <= 0x3163)
			{
				temp = findChoSung(ch);
				if (temp != null)
				{
					result = result + temp;
				} else
				{
					temp = findJwungSung(ch);
					if (temp != null)
					{
						result = result + temp;
					} else
					{
						temp = findJongSung(ch);
						if (temp != null)
						{
							result = result + temp;
						} else
						{
							result = result + ch;
						}
					}
				}
			} else
			{
				result = result + ch;
			}
		}
		return result;
	}

	private String findChoSung(char c)
	{
		String result = null;
		for (int i = 0; i < ChoSung.length; i++)
		{
			if (ChoSung[i] == c)
			{
				result = ChoSungEng[i];
				break;
			}
		}
		return result;
	}

	private String findJongSung(char c)
	{
		String result = null;
		for (int i = 0; i < JongSung.length; i++)
		{
			if (JongSung[i] == c)
			{
				result = JongSungEng[i];
				break;
			}
		}
		return result;
	}

	private String findJwungSung(char c)
	{
		String result = null;
		for (int i = 0; i < JwungSung.length; i++)
		{
			if (JwungSung[i] == c)
			{
				result = JwungSungEng[i];
				break;
			}
		}
		return result;
	}

	/**
	 * 해당 문자에 따른 코드를 추출한다.
	 * 
	 * @param type
	 *            초성 : chosung, 중성 : jungsung, 종성 : jongsung 구분
	 * @param char 해당 문자
	 */
	private int getCode(CodeType type, String c)
	{

		// 종성
		String[] fin = { "r", "R", "rt", "s", "sw", "sg", "e", "f", "fr", "fa", "fq", "ft", "fx", "fv", "fg", "a", "q",
						"qt", "t", "T", "d", "w", "c", "z", "x", "v", "g" };
		// new jspark code
		// String[] fin = { "r", "R", "rt", "s", "sw", "sg", "e", "E", "f", "fr", "fa", "fq", "ft", "fx",
		// "fv", "fg", "a", "q", "Q", "qt", "t", "T", "d", "w", "W", "c", "z", "x", "v", "g" };

		switch (type)
		{
			case CODE_TYPE_CHOSUNG:
				for (int i = 0; i < ChoSungEng.length; i++)
				{
					if (ChoSungEng[i].equals(c))
					{
						return i * 21 * 28;
					}
				}
				break;
			case CODE_TYPE_JWUNGSUNG:

				for (int i = 0; i < JwungSungEng.length; i++)
				{
					if (JwungSungEng[i].equals(c))
					{
						return i * 28;
					}
				}
				break;
			case CODE_TYPE_JONGSUNG:
				for (int i = 0; i < fin.length; i++)
				{
					if (fin[i].equals(c))
					{
						return i + 1;
					}
				}

				break;
			default:
				System.out.println("잘못된 타입 입니다");
		}

		return -1;
	}

	// 두 자로된 종성을 체크하고, 있다면 값을 리턴한다.
	// 없으면 리턴값은 -1
	private int getDoubleFinal(int i, String eng)
	{
		if ((i + 2) > eng.length())
		{
			return -1;
		} else
		{
			return getCode(CodeType.CODE_TYPE_JONGSUNG, eng.substring(i, i + 2));
		}
	}

	// 두 자로 된 중성을 체크하고, 있다면 값을 리턴한다.
	// 없으면 리턴값은 -1
	private int getDoubleMedial(int i, String eng)
	{
		int result;
		if ((i + 2) > eng.length())
		{
			return -1;
		} else
		{
			result = getCode(CodeType.CODE_TYPE_JWUNGSUNG, eng.substring(i, i + 2));
			if (result != -1)
			{
				return result;
			} else
			{
				return -1;
			}
		}
	}

	// 한 자로된 종성값을 리턴한다
	// 인덱스를 벗어낫다면 -1을 리턴
	private int getSingleFinal(int i, String eng)
	{
		if ((i + 1) <= eng.length())
		{
			return getCode(CodeType.CODE_TYPE_JONGSUNG, eng.substring(i, i + 1));
		} else
		{
			return -1;
		}
	}

	// 한 자로 된 중성값을 리턴한다
	// 인덱스를 벗어낫다면 -1을 리턴
	private int getSingleMedial(int i, String eng)
	{
		if ((i + 1) <= eng.length())
		{
			return getCode(CodeType.CODE_TYPE_JWUNGSUNG, eng.substring(i, i + 1));
		} else
		{
			return -1;
		}
	}

	@Deprecated
	public String hangulToJaso(String s)
	{
		int a, b, c; // 자소 버퍼: 초성/중성/종성 순
		String result = "";

		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);

			if (ch >= 0xAC00 && ch <= 0xD7A3)
			{ // "AC00:가" ~ "D7A3:힣" 에 속한 글자면 분해
				c = ch - 0xAC00;
				a = c / (21 * 28);
				c = c % (21 * 28);
				b = c / 28;
				c = c % 28;

				result = result + ChoSung[a] + JwungSung[b];
				if (c != 0)
					result = result + JongSung[c]; // c가 0이 아니면, 즉 받침이 있으면
			} else
			{
				result = result + ch;
			}
		}
		return result;
	}

	/**
	 * 영어를 한글로...
	 */
	public String rebuildEngToKor(String eng)
	{
		StringBuffer sb = new StringBuffer();

		int initialCode = 0, medialCode = 0, finalCode = 0;
		int tempMedialCode, tempFinalCode;

		for (int i = 0; i < eng.length(); i++)
		{
			char otherCh = eng.charAt(i);

			// 영어
			if (((0x61 <= otherCh && otherCh <= 0x7A) || (0x41 <= otherCh && otherCh <= 0x5A)) == false)
			{
				sb.append(eng.substring(i, i + 1));
				continue;
			}

			// TODO

			// 초성코드 추출
			initialCode = getCode(CodeType.CODE_TYPE_CHOSUNG, eng.substring(i, i + 1));
			i++; // 다음문자로
			String s = String.valueOf((char) (initialCode));

			// 중성코드 추출
			tempMedialCode = getDoubleMedial(i, eng); // 두 자로 이루어진 중성코드 추출

			if (tempMedialCode != -1)
			{
				medialCode = tempMedialCode;
				i += 2;
			} else
			{ // 없다면,
				medialCode = getSingleMedial(i, eng); // 한 자로 이루어진 중성코드 추출
				i++;
			}

			// 종성코드 추출
			tempFinalCode = getDoubleFinal(i, eng); // 두 자로 이루어진 종성코드 추출
			if (tempFinalCode != -1)
			{
				finalCode = tempFinalCode;
				// 그 다음의 중성 문자에 대한 코드를 추출한다.
				tempMedialCode = getSingleMedial(i + 2, eng);
				if (tempMedialCode != -1)
				{ // 코드 값이 있을 경우
					finalCode = getSingleFinal(i, eng); // 종성 코드 값을 저장한다.
				} else
				{
					i++;
				}
			} else
			{ // 코드 값이 없을 경우 ,
				tempMedialCode = getSingleMedial(i + 1, eng); // 그 다음의 중성 문자에 대한 코드 추출.

				if (tempMedialCode != -1)
				{ // 그 다음에 중성 문자가 존재할 경우,
					finalCode = 0; // 종성 문자는 없음.
					i--;

				} else
				{
					finalCode = getSingleFinal(i, eng); // 종성 문자 추출
					if (finalCode == -1)
						finalCode = 0;
				}
			}

			sb.append((char) (0xAC00 + initialCode + medialCode + finalCode));
		}
		return sb.toString();
	}

	/**
	 * 한글기준의 문자열을 입력받아서 한글의 경우에는 영타기준으로 변경한다.
	 * 
	 * @param s
	 *            한글/영문/특수문자가 합쳐진 문자열
	 * @return 영타기준으로 변경된 문자열값
	 */
	public String rebuildKorToEng(String s) throws Exception
	{
		// *****************************************
		// 0xAC00 + ( (초성순서 * 21) + 중성순서 ) * 28 + 종성순서 = 한글유니코드값
		// ( (초성순서 * 21) + 중성순서 ) * 28 + 종성순서 = 순수한글코드
		// 순수한글코드 % 28 = 종성
		// ( (순수한글코드 - 종성) / 28 ) % 21 = 중성
		// ( ( ( 순수한글코드 - 종성) / 28) - 중성) ) / 21 = 초성
		// *******************************************

		int a, b, c; // 자소 버퍼: 초성/중성/종성 순
		String result = "";

		String[] SingleJaumTotalEng = { "r", "R", "rt", "s", "sw", "sg", "e", "E", "f", "fr", "fa", "fq", "ft", "fx",
						"fv", "fg", "a", "q", "Q", "qt", "t", "T", "d", "w", "W", "c", "z", "x", "v", "g" };

		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);

			if (ch >= 0xAC00 && ch <= 0xD7A3)
			{ // "AC00:가" ~ "D7A3:힣" 에 속한 글자면 분해
				c = ch - 0xAC00;
				a = c / (21 * 28);
				c = c % (21 * 28);
				b = c / 28;
				c = c % 28;

				result = result + ChoSungEng[a] + JwungSungEng[b];
				if (c != 0)
					result = result + JongSungEng[c]; // c가 0이 아니면, 즉 받침이 있으면
			} else if (ch >= 0x3131 && ch <= 0x314E)
			{
				// 단일 자음
				c = (ch - 0x3131);
				result = result + SingleJaumTotalEng[c];
			} else if (ch >= 0x314F && ch <= 0x3163)
			{
				// 단일 모음
				c = (ch - 0x314F);
				result = result + JwungSungEng[c];
			} else
			{
				result = result + ch;
			}
		}
		return result;
	}

}
