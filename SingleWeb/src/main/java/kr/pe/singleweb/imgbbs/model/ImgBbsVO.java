package kr.pe.singleweb.imgbbs.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ImgBbsVO
 * 		: 이미지 게시판 글 Value object 클래스.
 *
 * @author 강인웅 e-mail: woong8609@gmail.com
 * @since 2014. 12. 17.
 */
public class ImgBbsVO
{
	/**
	 * idx
	 * 		: 이미지 게시판 클 번호.
	 */
	private int idx;
	/**
	 * subject
	 * 		: 이미지 게시판 글 제목.
	 */
	private String subject;
	/**
	 * writer
	 * 		: 이미지 게시판 글 작성자.
	 */
	private String writer;
	/**
	 * content
	 * 		: 이지미 게시판 글 내용.
	 */
	private String content;
	/**
	 * regTs
	 * 		: 이미지 게시판 글 최초 작성 일시.
	 */
	private String regTimestamp;
	/**
	 * modTs
	 * 		: 이미지 게시판 글 최종 수정 일시.
	 */
	private String modTimestamp;
	/**
	 * hit
	 * 		: 이미지 게시판 글 조회 수.
	 */
	private int hit;
	/**
	 * ip
	 * 		: 이미지 게시판 글 최초 작성 IP Address.
	 */
	private String ip;
	/**
	 * imgBbsFileVO
	 * 		: 이미지 게시판 파일 Value object List.
	 */
	private List<ImgBbsFileVO> imgBbsFileList;

	public int getIdx()
	{
		return idx;
	}

	public void setIdx(int idx)
	{
		this.idx = idx;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getWriter()
	{
		return writer;
	}

	public void setWriter(String writer)
	{
		this.writer = writer;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getRegTimestamp()
	{
		return regTimestamp;
	}

	public void setRegTimestamp(String regTimestamp)
	{
		this.regTimestamp = regTimestamp;
	}

	public String getModTimestamp()
	{
		return modTimestamp;
	}

	public void setModTimestamp(String modTimestamp)
	{
		this.modTimestamp = modTimestamp;
	}

	public int getHit()
	{
		return hit;
	}

	public void setHit(int hit)
	{
		this.hit = hit;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public List<ImgBbsFileVO> getImgBbsFileList()
	{
		return imgBbsFileList;
	}

	public void setImgBbsFileList(List<ImgBbsFileVO> imgBbsFileList)
	{
		this.imgBbsFileList = imgBbsFileList;
	}

	/** 
	 * Override
	 * 		: 'toString()' Method를 해당 클래스에 맞게 overriding.
	 *
	 * @author 강인웅 e-mail: woong8609@gmail.com
	 * @since 2014. 12. 17.
	 */
	@Override
	public String toString()
	{
		return "ImgBbsVO [idx=" + idx + ", subject=" + subject + ", writer=" + writer + ", content=" + content
						+ ", regTimestamp=" + regTimestamp + ", modTimestamp=" + modTimestamp + ", hit=" + hit
						+ ", ip=" + ip + ", imgBbsFileList=" + imgBbsFileList.toString() + "]";
	}
}