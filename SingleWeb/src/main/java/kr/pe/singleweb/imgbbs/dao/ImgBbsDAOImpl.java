package kr.pe.singleweb.imgbbs.dao;

import java.util.List;
import java.util.Map;

import kr.pe.singleweb.imgbbs.model.ImgBbsVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ImgBbsDAOImpl
 * 		: 이미지 게시판 Data access object 구현 클래스.
 *
 * @author 강인웅 e-mail: woong8609@gmail.com
 * @since 2014. 12. 17.
 */
@Repository
public class ImgBbsDAOImpl implements ImgBbsDAO
{
	/**
	 * sqlSession
	 * 		: 설정된 dataSource의 연결 session.
	 */
	@Autowired
	private SqlSession sqlSession;
	
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
		return sqlSession.selectList("imgBbsSqlMapper.selectImgBbsList", map);
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
		return sqlSession.selectOne("imgBbsSqlMapper.getTotalCnt");
	}
}
