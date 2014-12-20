package kr.pe.singleweb.admin.web;

import kr.pe.singleweb.cmm.usr.service.SessionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController
{

	private final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private SessionService sessionService;

	public ModelAndView goAdminPage()
	{
		logger.debug("[goAdminPage]");
		ModelAndView mav = new ModelAndView();
		// TODO 관리자 권한 체크로직이 필요함
//		sessionService.getSessionUserInfo(request, response)
		mav.setViewName("/admin/index.tiles");
		return mav;
	}
}
