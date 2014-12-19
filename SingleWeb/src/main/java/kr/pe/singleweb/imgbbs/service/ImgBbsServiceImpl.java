package kr.pe.singleweb.imgbbs.service;

import java.util.List;
import java.util.Map;

import kr.pe.singleweb.imgbbs.dao.ImgBbsDAO;
import kr.pe.singleweb.imgbbs.model.ImgBbsVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ImgBbsServiceImpl
 * 		: 이미지 게시판 관리 Service 구련 클래스.
 *
 * @author 강인웅 e-mail: woong8609@gmail.com
 * @since 2014. 12. 17.
 */
@Service
public class ImgBbsServiceImpl implements ImgBbsService
{
	/**
	 * imgBbsDAO
	 * 		: 이미지 게시판 Data access object 인스턴스.
	 */
	@Autowired
	private ImgBbsDAO imgBbsDAO;
	
	/** 
	 * Override 이유
	 * 		: implements interface 구현.
	 *
	 * @author 강인웅 e-mail: woong8609@gmail.com
	 * @since 2014. 12. 17.
	 */
	@Override
	public List<ImgBbsVO> selectImgBbsList(Map<String, Integer> map)
	{
		return imgBbsDAO.selectImgBbsList(map);
	}
	
	/** 
	 * Override 이유
	 * 		: implements interface 구현.
	 *
	 * @author 강인웅 e-mail: woong8609@gmail.com
	 * @since 2014. 12. 19.
	 */
	@Override
	public int getTotalCnt()
	{
		return imgBbsDAO.getTotalCnt();
	}
}
