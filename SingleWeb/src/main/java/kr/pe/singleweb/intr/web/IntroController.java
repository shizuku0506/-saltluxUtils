/*
 * 라이센스 위치
 */
package kr.pe.singleweb.intr.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * intro 페이지에서 사용되는 컨트롤러
 *
 * @author 박정선 e-mail: souler2585@gmail.com
 * @since 2014. 12. 14.
 */
@Controller
@RequestMapping(value = "/intr")
public class IntroController
{
	private static final Logger logger = LoggerFactory.getLogger(IntroController.class);

	/**
	 * intro 페이지 호출
	 *
	 * @author 박정선 e-mail: souler2585@gmail.com
	 * @since 2014. 12. 14.
	 */
	@RequestMapping(value = "index.do")
	public String goIntro()
	{
		logger.debug("goIntro");
		return "/intr/intr.tiles";
	}
}
