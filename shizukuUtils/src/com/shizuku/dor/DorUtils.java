/*
 * 라이센스 위치
 */
package com.shizuku.dor;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import com.shizuku.dor.vo.FileInfoVO;
import com.shizuku.dor.vo.FileSqlVO;

/**
 * DorUtils 설명<br/>
 * 솔트룩스 API에 관한 유틸
 * 
 * @author 박정선 e-mail: souler2585@gmail.com
 * @since 2014. 5. 19.
 */
public class DorUtils
{
	/**
	 * 첨부파일정보를 FileInfoVO리스트에 담아서 리턴
	 * 
	 * @author 박정선 e-mail: souler2585@gmail.com
	 * @since 2014. 5. 19.
	 */
	public List<FileInfoVO> getFileInfoList(Connection con, FileSqlVO sqlVO)
	{
		List<FileInfoVO> fileInfoList = new ArrayList<FileInfoVO>();

		if (StringUtils.isBlank(sqlVO.getAttachSql()) && StringUtils.isBlank(sqlVO.getAttachSqlKey()))
		{
			return fileInfoList;
		}

		PreparedStatement prst = null;
		ResultSet rs = null;

		try
		{
			prst = con.prepareStatement(sqlVO.getAttachSql());

			prst.setString(1, sqlVO.getAttachSqlKey());

			rs = prst.executeQuery();

			while (rs.next())
			{
				FileInfoVO fileInfo = new FileInfoVO();

				String fileId = StringUtils.defaultIfBlank(rs.getString(sqlVO.getAttachFileId()), StringUtils.EMPTY)
								.trim();
				String fileName = StringUtils
								.defaultIfBlank(rs.getString(sqlVO.getAttachFileName()), StringUtils.EMPTY).trim();
				String fileViewName = StringUtils.defaultIfBlank(rs.getString(sqlVO.getAttachFileViewName()),
								StringUtils.EMPTY).trim();
				String filePathName = StringUtils.defaultIfBlank(rs.getString(sqlVO.getAttachFilePath()),
								StringUtils.EMPTY).trim();
				String fileSize = StringUtils
								.defaultIfBlank(rs.getString(sqlVO.getAttachFileSize()), StringUtils.EMPTY).trim();
				String fileExt = StringUtils.defaultIfBlank(rs.getString(sqlVO.getAttachFileExt()), StringUtils.EMPTY)
								.trim();
				String fileUriName = StringUtils.defaultIfBlank(rs.getString(sqlVO.getAttachFileUri()),
								StringUtils.EMPTY).trim();

				fileInfo.setFileId(fileId);
				fileInfo.setFileName(fileName);
				fileInfo.setFileViewName(fileViewName);
				fileInfo.setFilePathName(filePathName);

				if (StringUtils.isBlank(fileSize) || StringUtils.isBlank(fileExt))
				{
					File srcFile = new File(filePathName);
					if (srcFile.exists() == true && srcFile.isFile() == true)
					{
						fileExt = FilenameUtils.getExtension(srcFile.getAbsolutePath());
						fileSize = String.valueOf(srcFile.length());
					} else if (StringUtils.isBlank(fileUriName) == false)
					{
						File trgFile = new File(sqlVO.getCopyFilePath());
						URL srcUrl = new URL(sqlVO.getAttachFileUri());
						FileUtils.copyURLToFile(srcUrl, trgFile);

						fileExt = FilenameUtils.getExtension(trgFile.getAbsolutePath());
						fileSize = String.valueOf(trgFile.length());
					} else
					{
						fileSize = "0";
						fileExt = StringUtils.EMPTY;
					}
				}

				fileInfo.setFileSize(fileSize);
				fileInfo.setFileExt(fileExt);
				fileInfo.setFileUriName(fileUriName);

				fileInfoList.add(fileInfo);
			}
		} catch (Exception e)
		{
			fileInfoList.clear();
		} finally
		{
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (prst != null)
			{
				try
				{
					prst.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return fileInfoList;
	}
}
