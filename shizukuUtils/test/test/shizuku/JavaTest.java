package test.shizuku;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JavaTest
{

	@Before
	public void setUp() throws Exception
	{

	}

	@Test
	public void test()
	{
		int i = 0;
		i = 1024 * 8;
		System.out.println(i);
	}

	@After
	public void end()
	{
		System.out.println("END");
	}

}
