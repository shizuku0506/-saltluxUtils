package kr.pe.singleweb.imgbbs.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import kr.pe.singleweb.imgbbs.model.ImgBbsVO;

/**
 * ImgBbsService
 * 		: 이미지 게시판 관리 Service 인터페이스.
 *
 * @author 강인웅 e-mail: woong8609@gmail.com
 * @since 2014. 12. 17.
 */
@Component
public interface ImgBbsService
{
	/**
	 * @param map
	 * 		: firstRowNo, lastRowNo
	 * @return
	 * 		: 이미지 게시판 목록.
	 *
	 * @author 강인웅 e-mail: woong8609@gmail.com
	 * @since 2014. 12. 19.
	 */
	public List<ImgBbsVO> selectImgBbsList(Map<String, Integer> map);
	
	/**
	 * @return
	 * 		: 이미지 게시판 전체 글 수.
	 *
	 * @author 강인웅 e-mail: woong8609@gmail.com
	 * @since 2014. 12. 19.
	 */
	public int getTotalCnt();
}
