package test.shizuku;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jspark.compress.CompressUtils;

public class CompressTest
{
	private File srcFile = new File("d:\\test1\\");

	private File destFile = new File("d:\\test1\\out\\x.zip");

	private String encoding = "UTF-8";

	private boolean includeSrc = false;

	@Before
	public void setUp() throws Exception
	{
		// TODO 변수재정의 필요할시 사용
		srcFile = new File("d:\\test1\\", "../test/vv/");
		includeSrc = true;
	}

	@Test
	public void test() throws Exception
	{
		CompressUtils compressUtils = new CompressUtils();

		// compressUtils.Compress(srcFile, destFile, encoding, includeSrc);

		srcFile = new File("d:\\test1\\test1.7z");
		destFile = new File("d:\\test1\\a");
		compressUtils.unCompress(srcFile, destFile, encoding);

	}

	@After
	public void end()
	{
		System.out.println("@@@ END");
	}

}
