package test.shizuku;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HostTest
{
	private String hostName = StringUtils.EMPTY;

	private String ip = StringUtils.EMPTY;

	private String port = StringUtils.EMPTY;

	@Before
	public void setUp() throws Exception
	{
		hostName = "www.google.co.kr";
	}

	@Test
	public void test()
	{
		boolean isSuccess = false;
		long startTime = 0L;
		try
		{
			InetAddress inet = InetAddress.getByName(hostName);
			isSuccess = inet.isReachable(100);

			startTime = startTime + 100;

			while (isSuccess == true)
			{
				System.out.println(startTime);
			}
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@After
	public void end()
	{
		System.out.println("END");
	}

}
