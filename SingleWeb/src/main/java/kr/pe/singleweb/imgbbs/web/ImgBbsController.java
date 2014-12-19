package kr.pe.singleweb.imgbbs.web;

import java.util.HashMap;
import java.util.Map;

import kr.pe.singleweb.imgbbs.service.ImgBbsService;
import kr.pe.singleweb.imgbbs.util.PagingUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ImgBbsController
 * 		: 이미지 게시판의 View 와 Model 을 연결해 주는 클래스.
 *
 * @author 강인웅 e-mail: woong8609@gmail.com
 * @since 2014. 12. 17.
 */
@Controller
@RequestMapping(value = "/imgbbs")
public class ImgBbsController
{
	/**
	 * logger
	 * 		: logger instance generation.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ImgBbsController.class);

	/**
	 * imgBbsService
	 * 		: 이미지 게시판 관리 Service 인스턴스.
	 */
	@Autowired
	private ImgBbsService imgBbsService;
	
	/**
	 * imgage bbs list page call.
	 * 
	 * @return
	 * 		: 이미지 게시판 목록.
	 *
	 * @author 강인웅 e-mail: woong8609@gmail.com
	 * @since 2014. 12. 17.
	 */
	@RequestMapping(value = "imgbbsList.do")
	public ModelAndView imgBbsList()
	{
		logger.debug(this.getClass().getName() + " imgBbsList() Call!!");
		
		PagingUtil paging = new PagingUtil();
//		paging.makePaging(1, imgBbsService.getTotalCnt());
		paging.makePaging(1, imgBbsService.getTotalCnt(), 1, 2);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("firstRow", paging.getFirstRow());
		map.put("lastRow", paging.getLastRow());
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("imgBbsList", imgBbsService.selectImgBbsList(map));
		modelMap.addAttribute("paging", paging);
		
		ModelAndView model = new ModelAndView();
		model.addAllObjects(modelMap);
		model.setViewName("/imgbbs/imgbbsList.tiles");
		
		return model;
	}
}
