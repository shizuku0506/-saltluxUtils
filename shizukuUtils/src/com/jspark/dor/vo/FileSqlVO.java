package com.jspark.dor.vo;

import org.apache.commons.lang.StringUtils;

/**
 * 첨부파일 VO를 담기위한 Sql 필드명 지정한다
 * 
 * @author 박정선 e-mail: jspark@saltlux.com
 * @since 2014. 5. 19.
 */
public class FileSqlVO
{
	private String attachSql = StringUtils.EMPTY;

	private String attachSqlKey = StringUtils.EMPTY;

	private String attachFileId = StringUtils.EMPTY;

	private String attachFileName = StringUtils.EMPTY;

	private String attachFileViewName = StringUtils.EMPTY;

	private String attachFilePath = StringUtils.EMPTY;

	private String attachFileSize = StringUtils.EMPTY;

	private String attachFileExt = StringUtils.EMPTY;

	private String attachFileUri = StringUtils.EMPTY;

	private String copyFilePath = StringUtils.EMPTY;

	public String getAttachSql()
	{
		return attachSql;
	}

	public void setAttachSql(String attachSql)
	{
		this.attachSql = attachSql;
	}

	public String getAttachSqlKey()
	{
		return attachSqlKey;
	}

	public void setAttachSqlKey(String attachSqlKey)
	{
		this.attachSqlKey = attachSqlKey;
	}

	public String getAttachFileId()
	{
		return attachFileId;
	}

	public void setAttachFileId(String attachFileId)
	{
		this.attachFileId = attachFileId;
	}

	public String getAttachFileName()
	{
		return attachFileName;
	}

	public void setAttachFileName(String attachFileName)
	{
		this.attachFileName = attachFileName;
	}

	public String getAttachFileViewName()
	{
		return attachFileViewName;
	}

	public void setAttachFileViewName(String attachFileViewName)
	{
		this.attachFileViewName = attachFileViewName;
	}

	public String getAttachFilePath()
	{
		return attachFilePath;
	}

	public void setAttachFilePath(String attachFilePath)
	{
		this.attachFilePath = attachFilePath;
	}

	public String getAttachFileSize()
	{
		return attachFileSize;
	}

	public void setAttachFileSize(String attachFileSize)
	{
		this.attachFileSize = attachFileSize;
	}

	public String getAttachFileExt()
	{
		return attachFileExt;
	}

	public void setAttachFileExt(String attachFileExt)
	{
		this.attachFileExt = attachFileExt;
	}

	public String getAttachFileUri()
	{
		return attachFileUri;
	}

	public void setAttachFileUri(String attachFileUri)
	{
		this.attachFileUri = attachFileUri;
	}

	public String getCopyFilePath()
	{
		return copyFilePath;
	}

	public void setCopyFilePath(String copyFilePath)
	{
		this.copyFilePath = copyFilePath;
	}

}
