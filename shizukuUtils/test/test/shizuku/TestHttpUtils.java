package test.shizuku;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.shizuku.httpclient.HttpClient;
import com.shizuku.httpclient.HttpClientUtils;

public class TestHttpUtils
{

	@Test
	public void test()
	{
		// devapi.systran.co.kr:8990/demoapis/trans/t/ko/en?access_token=0255b71ea9d341956a8db2cab1bd47a6e47714d3ee63fba0c9b9ce689a02f31c&src=한글이다

		com.shizuku.httpclient.HttpClientUtils c = new HttpClientUtils();
		Map<String, String> param = new HashMap<String, String>();
		String s = "";

		// GET
		// param.put(HttpClient.TARGET_URL,
		// "http://devapi.systran.co.kr:8990/demoapis/trans/t/ko/en?access_token=0255b71ea9d341956a8db2cab1bd47a6e47714d3ee63fba0c9b9ce689a02f31c&src=한글이다");
		// s = c.getRestGetValue(param);

		// POST
		param.put(HttpClient.TARGET_URL, "https://storeawsapi.ziny.us/account/update");
		param.put("version", "0.9.6");
		param.put("access_token", "111998b09337ae8c8679f09cc756f54095006490");
		param.put("notifications", "{'morning':'08:00','afternoon':'12:00','evening':'17:00','night':'21:00'}");
		s = c.getRestPostValue(null, param);

		// End
		System.out.println("S : " + s);
	}

}
