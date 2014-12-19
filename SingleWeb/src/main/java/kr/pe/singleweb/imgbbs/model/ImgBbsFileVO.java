package kr.pe.singleweb.imgbbs.model;

/**
 * ImgBbsFileVO
 * 		: 이미지 파일 Value object 클래스.
 *
 * @author 강인웅 e-mail: woong8609@gmail.com
 * @since 2014. 12. 17.
 */
public class ImgBbsFileVO
{
	/**
	 * fileIdx
	 * 		: 이미지 파일 번호.
	 */
	private int fileIdx;
	/**
	 * idx
	 * 		: 이미지 게시판 글 번호.
	 */
	private int idx;
	/**
	 * regDate
	 * 		: 파일 등록 일자.
	 */
	private String regDate;
	/**
	 * fileSize
	 * 		: 이미지 파일 크기.
	 */
	private int fileSize;
	/**
	 * fileName
	 * 		: 이미지 파일 실제 이름.
	 */
	private String fileName;
	/**
	 * fileType
	 * 		: 이미지 파일 형식.
	 */
	private String fileType;
	/**
	 * tempFileName
	 * 		: 이미지 파일 storage 디렉토리의 저장 이름.
	 */
	private String tempFileName;
	/**
	 * deleteYn
	 * 		: 이미지 파일 삭제 여부.
	 */
	private String deleteYn;
	
	public int getFileIdx()
	{
		return fileIdx;
	}
	public void setFileIdx(int fileIdx)
	{
		this.fileIdx = fileIdx;
	}
	public int getIdx()
	{
		return idx;
	}
	public void setIdx(int idx)
	{
		this.idx = idx;
	}
	public String getRegDate()
	{
		return regDate;
	}
	public void setRegDate(String regDate)
	{
		this.regDate = regDate;
	}
	public int getFileSize()
	{
		return fileSize;
	}
	public void setFileSize(int fileSize)
	{
		this.fileSize = fileSize;
	}
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getFileType()
	{
		return fileType;
	}
	public void setFileType(String fileType)
	{
		this.fileType = fileType;
	}
	public String getTempFileName()
	{
		return tempFileName;
	}
	public void setTempFileName(String tempFileName)
	{
		this.tempFileName = tempFileName;
	}
	public String getDeleteYn()
	{
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn)
	{
		this.deleteYn = deleteYn;
	}
	
	/** 
	 * Override 이유
	 * 		: 'toString()' Method를 해당 클래스에 맞게 overriding.
	 *
	 * @author 강인웅 e-mail: woong8609@gmail.com
	 * @since 2014. 12. 17.
	 */
	@Override
	public String toString()
	{
		return "ImgBbsFileVO [fileIdx=" + fileIdx + ", idx=" + idx + ", regDate=" + regDate + ", fileSize=" + fileSize
						+ ", fileName=" + fileName + ", fileType=" + fileType + ", tempFileName=" + tempFileName
						+ ", deleteYn=" + deleteYn + "]";
	}
}
