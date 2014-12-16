package kr.pe.singleweb.cmm.usr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 사용자와 관련된 컨트롤러
 *
 * @author 박정선 e-mail: souler2585@gmail.com
 * @since 2014. 12. 15.
 */
@Controller
@RequestMapping(value = "/usr")
public class UserController
{

	public ModelAndView goLoginPage(ModelAndView mav)
	{
		
		mav.setViewName("/login.tiles");
		return mav;
	}
}
