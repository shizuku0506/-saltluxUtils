package com.jspark.compress;

import java.io.File;
import java.io.FileInputStream;
import java.util.Stack;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

public class Compressor
{
	private final int BUF_SIZE = 1024 * 8;

	public static void main(String[] args)
	{
		Compressor c = new Compressor();
		try
		{
			c.compressZIP(new File("d:\\test\\vva\\"), new File("d:\\test\\a.zip"), "UTF-8", false);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @param srcFile
	 *            압축 타겟 대상
	 * @param destFile
	 *            압축 후 생성될 파일
	 * @param encoding
	 *            인코딩
	 * @param includeSrc
	 *            부모디렉토리의 압축 여부
	 * @throws Exception
	 * 
	 * @author 박정선 e-mail: jspark@saltlux.com
	 * @since 2014. 5. 20.
	 */
	public void compressZIP(File srcFile, File destFile, String encoding, boolean includeSrc) throws Exception
	{
		ZipArchiveOutputStream zipAos = null;
		ZipArchiveEntry zipAe = null;
		FileInputStream fis = null;
		File root = null;
		byte[] buf = new byte[BUF_SIZE];

		String name;
		int length;

		zipAos = new ZipArchiveOutputStream(destFile);

		Stack<File> stack = new Stack<File>();

		if (srcFile.isDirectory())
		{
			if (includeSrc)
			{
				stack.push(srcFile);
				root = srcFile.getParentFile();
			} else
			{
				File[] fs = srcFile.listFiles();
				for (int i = 0; i < fs.length; i++)
				{
					stack.push(fs[i]);
				}
				root = srcFile;
			}
		} else
		{
			stack.push(srcFile);
			root = srcFile.getParentFile();
		}

		while (!stack.isEmpty())
		{
			File f = stack.pop();
			name = toPath(root, f);
			if (f.isDirectory())
			{
				File[] fs = f.listFiles();
				for (int i = 0; i < fs.length; i++)
				{
					if (fs[i].isDirectory())
						stack.push(fs[i]);
					else
						stack.add(0, fs[i]);
				}
			} else
			{
				zipAe = new ZipArchiveEntry(name);
				zipAos.putArchiveEntry(zipAe);
				fis = new FileInputStream(f);
				while ((length = fis.read(buf, 0, buf.length)) >= 0)
				{
					zipAos.write(buf, 0, length);
				}
				fis.close();
				zipAos.closeArchiveEntry();
			}
		}
		
		if (zipAos != null)
		{
			zipAos.close();
		}
	}

	private String toPath(File root, File dir)
	{
		String path = dir.getAbsolutePath();
		path = path.substring(root.getAbsolutePath().length()).replace(File.separatorChar, '/');
		if (path.startsWith("/"))
			path = path.substring(1);
		if (dir.isDirectory() && !path.endsWith("/"))
			path += "/";
		return path;
	}
}
