package com.jspark.dor.vo;

import org.apache.commons.lang.StringUtils;

/**
 * 첨부파일 정보를 담는 VO
 *
 * @author 박정선 e-mail: jspark@saltlux.com
 * @since 2014. 5. 19.
 */
public class FileInfoVO
{
	/**
	 * 파일 ID
	 */
	String fileId = StringUtils.EMPTY;

	/**
	 * 파일 물리적네임
	 */
	String fileName = StringUtils.EMPTY;

	/**
	 * 파일 뷰네임
	 */
	String fileViewName = StringUtils.EMPTY;

	/**
	 * 파일의 절대경로
	 */
	String filePathName = StringUtils.EMPTY;

	/**
	 * 파일 크기
	 */
	String fileSize = StringUtils.EMPTY;

	/**
	 * 파일 확장자
	 */
	String fileExt = StringUtils.EMPTY;

	/**
	 * 파일 URI 경로 <br/>
	 * 파일 절대경로로 못받을경우 URI로 가져오는 형태가 존재함
	 */
	String fileUriName = StringUtils.EMPTY;

	public String getFileId()
	{
		return fileId;
	}

	public void setFileId(String fileId)
	{
		this.fileId = fileId;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileViewName()
	{
		return fileViewName;
	}

	public void setFileViewName(String fileViewName)
	{
		this.fileViewName = fileViewName;
	}

	public String getFilePathName()
	{
		return filePathName;
	}

	public void setFilePathName(String filePathName)
	{
		this.filePathName = filePathName;
	}

	public String getFileSize()
	{
		return fileSize;
	}

	public void setFileSize(String fileSize)
	{
		this.fileSize = fileSize;
	}

	public String getFileExt()
	{
		return fileExt;
	}

	public void setFileExt(String fileExt)
	{
		this.fileExt = fileExt;
	}

	public String getFileUriName()
	{
		return fileUriName;
	}

	public void setFileUriName(String fileUriName)
	{
		this.fileUriName = fileUriName;
	}

}
