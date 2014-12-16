/*
 * 라이센스 위치
 */
package kr.pe.singleweb.cmm.usr.model;

import org.apache.commons.lang.StringUtils;

/**
 * 사용자 정보 VO
 *
 * @author 박정선 e-mail: souler2585@gmail.com
 * @since 2014. 12. 15.
 */
public class UserVO
{
	private String seq = StringUtils.EMPTY;

	private String userId = StringUtils.EMPTY;

	private String userName = StringUtils.EMPTY;

	private String userPassword = StringUtils.EMPTY;

	private String userPhone = StringUtils.EMPTY;

	private String userMail = StringUtils.EMPTY;

	private String rollCode = StringUtils.EMPTY;

	private String createDate = StringUtils.EMPTY;

	private String updateDate = StringUtils.EMPTY;

	private String deleteYn = StringUtils.EMPTY;

	public String getSeq()
	{
		return seq;
	}

	public void setSeq(String seq)
	{
		this.seq = seq;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPassword()
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}

	public String getUserPhone()
	{
		return userPhone;
	}

	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}

	public String getUserMail()
	{
		return userMail;
	}

	public void setUserMail(String userMail)
	{
		this.userMail = userMail;
	}

	public String getRollCode()
	{
		return rollCode;
	}

	public void setRollCode(String rollCode)
	{
		this.rollCode = rollCode;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public String getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(String updateDate)
	{
		this.updateDate = updateDate;
	}

	public String getDeleteYn()
	{
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn)
	{
		this.deleteYn = deleteYn;
	}

}
