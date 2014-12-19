package kr.pe.singleweb.test.web;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kr.pe.singleweb.test.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TestController
{
	/**
	 * logger : logger instance generation.
	 */
	private final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private TestService testService;

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
	@RequestMapping(value = "testJson.do")
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

	@RequestMapping(value = "testDao.do")
	@ResponseBody
	public ModelMap testDao()
	{
		logger.debug("testDao Test");

		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("testString", "testString");
		modelMap.addAttribute("testServiceMap", testService.selectTestValue());

		return modelMap;
	}
}
