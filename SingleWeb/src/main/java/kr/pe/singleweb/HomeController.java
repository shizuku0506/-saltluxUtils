package kr.pe.singleweb;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController
{
	/**
	 * logger : logger instance generation.
	 */
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * @param locale
	 *            : 지역화 지정 변수
	 * @param model
	 *            :
	 * @return
	 *
	 * @author 강인웅 e-mail: woong8609@nate.com
	 * @since 2014. 12. 8.
	 */
	@RequestMapping(value = "index.do")
	public String home(Locale locale, Model model)
	{
		logger.debug("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		// return "index";
		return "index.tiles";
	}

	/**
	 * json 값 테스트
	 *
	 * @author 박정선 e-mail: souler2585@gmail.com
	 * @since 2014. 12. 11.
	 */
	@RequestMapping(value = "test.do")
	@ResponseBody
	public ModelMap testJson()
	{
		logger.debug("json Test");

		ModelMap modelMap = new ModelMap();

		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		list.add("555");

		modelMap.addAttribute("testString", "testString");
		modelMap.addAttribute("list", list);

		return modelMap;
	}

}
