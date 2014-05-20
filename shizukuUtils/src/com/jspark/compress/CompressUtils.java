package com.jspark.compress;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

public class CompressUtils
{
	private Compressor compressor;

	private UnCompressor unCompressor;

	private final String extensionZIP = "zip";

	private final String extensionTAR = "tar";

	private final String extensionBZIP = "bz2"; // .tar.bz2

	private final String extensionGZIP = "gz"; // .tar.gz

	private final String extensionSEVENZIP = "7z";

	public CompressUtils()
	{
		if (compressor == null)
		{
			compressor = new Compressor();
		}

		if (unCompressor == null)
		{
			unCompressor = new UnCompressor();
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
	 * @since 2014. 5. 20.
	 */
	public void unCompress(File srcFile, File destFile, String encoding)
	{
		if (destFile.exists() == false)
		{
			destFile.mkdir();
		}
		try
		{
			if (StringUtils.equalsIgnoreCase(FilenameUtils.getExtension(srcFile.getAbsolutePath()), extensionZIP))
			{

				unCompressor.unCompressZIP(srcFile, destFile, encoding);
			} else if (StringUtils
							.equalsIgnoreCase(FilenameUtils.getExtension(srcFile.getAbsolutePath()), extensionTAR))
			{
				unCompressor.unCompressTAR(srcFile, destFile, encoding);
			} else if (StringUtils.equalsIgnoreCase(FilenameUtils.getExtension(srcFile.getAbsolutePath()),
							extensionSEVENZIP))
			{
				unCompressor.unCompressSEVENZIP(srcFile, destFile, encoding);
			} else if (StringUtils.equalsIgnoreCase(FilenameUtils.getExtension(srcFile.getAbsolutePath()),
							extensionBZIP))
			{
				// TODO
				unCompressor.unCompressBZIP(srcFile, destFile, encoding);
			} else if (StringUtils.equalsIgnoreCase(FilenameUtils.getExtension(srcFile.getAbsolutePath()),
							extensionGZIP))
			{
				unCompressor.unCompressGZIP(srcFile, destFile, encoding);
			}

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
	 * 
	 * @author 박정선 e-mail: jspark@saltlux.com
	 * @since 2014. 5. 20.
	 */
	public void Compress(File srcFile, File destFile, String encoding, boolean includeSrc)
	{
		if (srcFile.exists() == false)
		{
			System.out.println("Source Compress Data is null !!!");
			return;
		}
		if (destFile.isDirectory() == true)
		{
			System.out.println("DestFile is Directory !!!");
			return;
		}

		try
		{
			// 압축대상 패스에 압축파일이 존재하면, 무한루프 돌아버림
			if (StringUtils.startsWithIgnoreCase(destFile.getCanonicalPath(), srcFile.getCanonicalPath()) == true)
			{
				System.out.println("Duplicated srcFile Path !!!");
				System.out.println("srcFile CanonicalPath : " + srcFile.getCanonicalPath());
				System.out.println("destFile CanonicalPath : " + destFile.getCanonicalPath());
				return;
			}
		} catch (IOException e)
		{
			System.out.println("Error get CanonicalPath !!! ");
			e.printStackTrace();
			return;
		}

		if (StringUtils.equalsIgnoreCase(FilenameUtils.getExtension(destFile.getAbsolutePath()), extensionZIP))
		{
			try
			{
				compressor.compressZIP(srcFile, destFile, encoding, includeSrc);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
