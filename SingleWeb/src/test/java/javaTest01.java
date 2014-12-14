import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class javaTest01
{

	@Test
	public void test()
	{
		Date date = new Date();

		StringBuffer sb = new StringBuffer();

		sb.append(date.toString());
		sb.append("jspark");
		System.out.println(sb);
	}

}
