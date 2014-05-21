package com.jspark.compress;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;

public class UnCompressor
{

	private final int BUF_SIZE = 1024 * 8;

	/**
	 * @param srcFile
	 *            압축 파일
	 * @param destFile
	 *            압축 해제될 디렉토리
	 * @param encoding
	 *            인코딩
	 * 
	 * @author 박정선 e-mail: jspark@saltlux.com
	 * @throws Exception
	 * @since 2014. 5. 20.
	 */
	public void unCompressZIP(File srcFile, File destFile, String encoding) throws Exception
	{
		ZipArchiveInputStream zipAis = null;
		ZipArchiveEntry zipAe = null;
		int nWritten = 0;
		byte[] buf = new byte[BUF_SIZE];

		zipAis = new ZipArchiveInputStream(new FileInputStream(srcFile), encoding);

		// Entry 하나씩 처리한다. while
		while ((zipAe = zipAis.getNextZipEntry()) != null)
		{
			File target = null;
			target = new File(destFile, zipAe.getName());
			if (zipAe.isDirectory()) // 디렉토리
			{
				target.mkdirs();
			} else
			{ // 파일
				File f = new File(target.getParent());
				if (f.exists() == false)
				{
					f.mkdir();
				}
				target.createNewFile();
				BufferedOutputStream bos = null;
				try
				{
					bos = new BufferedOutputStream(new FileOutputStream(target));

					while ((nWritten = zipAis.read(buf)) >= 0)
					{
						bos.write(buf, 0, nWritten);
					}
				} finally
				{
					if (bos != null)
					{
						bos.close();
					}
				}
			}
		}

		if (zipAis != null)
		{
			zipAis.close();
		}
	}

	/**
	 * @param srcFile
	 *            압축 파일
	 * @param destFile
	 *            압축 해제될 디렉토리
	 * @param encoding
	 *            인코딩
	 * 
	 * @author 박정선 e-mail: jspark@saltlux.com
	 * @throws Exception
	 * @since 2014. 5. 20.
	 */
	public void unCompressTAR(File srcFile, File destFile, String encoding) throws Exception
	{
		TarArchiveInputStream tarAis = null;
		TarArchiveEntry tarAe = null;
		int nWritten = 0;
		byte[] buf = new byte[BUF_SIZE];

		tarAis = new TarArchiveInputStream(new FileInputStream(srcFile), encoding);

		// Entry 하나씩 처리한다. while
		while ((tarAe = tarAis.getNextTarEntry()) != null)
		{
			File target = null;
			target = new File(destFile, tarAe.getName());
			if (tarAe.isDirectory()) // 디렉토리
			{
				target.mkdirs();
			} else
			{ // 파일
				File f = new File(target.getParent());
				if (f.exists() == false)
				{
					f.mkdir();
				}
				target.createNewFile();
				BufferedOutputStream bos = null;
				try
				{
					bos = new BufferedOutputStream(new FileOutputStream(target));

					while ((nWritten = tarAis.read(buf)) >= 0)
					{
						bos.write(buf, 0, nWritten);
					}
				} finally
				{
					if (bos != null)
					{
						bos.close();
					}
				}
			}
		}

		if (tarAis != null)
		{
			tarAis.close();
		}
	}

	/**
	 * @param srcFile
	 *            압축 파일
	 * @param destFile
	 *            압축 해제될 디렉토리
	 * @param encoding
	 *            인코딩
	 * 
	 * @author 박정선 e-mail: jspark@saltlux.com
	 * @throws Exception
	 * @since 2014. 5. 20.
	 */
	public void unCompressSEVENZIP(File srcFile, File destFile, String encoding) throws Exception
	{
		SevenZFile sevenZFile = new SevenZFile(srcFile);
		SevenZArchiveEntry sevenZAe = sevenZFile.getNextEntry();

		while (sevenZAe != null)
		{
			FileOutputStream fos = new FileOutputStream(new File(destFile, sevenZAe.getName()));
			byte[] buf = new byte[(int) sevenZAe.getSize()];
			sevenZFile.read(buf, 0, buf.length);
			fos.write(buf);
			if (fos != null)
			{
				fos.close();
			}
			sevenZAe = sevenZFile.getNextEntry();
		}

		if (sevenZFile != null)
		{
			sevenZFile.close();
		}
	}
}
