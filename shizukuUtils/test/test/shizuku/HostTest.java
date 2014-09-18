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

	public static void main(String[] args)
	{
		HostTest t = new HostTest();
		t.test();
	}

	@Before
	public void setUp() throws Exception
	{
		hostName = "127.0.0.1";
		hostName = "localhost";
		hostName = "www.google.co.kr";
	}

	@Test
	public void test()
	{
		boolean isSuccess = false;

		int callTime = 500;

		System.out.println("This ping Test.... > Target : [ " + hostName + " ]");

		try
		{
			InetAddress inet = InetAddress.getByName(hostName);

			do
			{
				System.out.println("Current Timeout Value : " + callTime / 1000D + " sencond");
				isSuccess = inet.isReachable(callTime);
				callTime = callTime + 100;

				if (callTime > 5000)
				{
					System.out.println("Call Timeout Out of Range [MAX : 5 second] .... bye !!");
					break;
				}
			} while (isSuccess == false);
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (isSuccess == true)
			{
				System.out.println("ping success !! ");
			} else
			{
				System.out.println("ping failed !! ");
			}
		}
	}

	@After
	public void end()
	{
		System.out.println("END");
	}

}
