package com.jh.org3;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 1. 자바 버전 맞추기 
 * 	  build path
 *    project facets
 *    
 * 2. web.xml j 소문자를 대문자로
 * 
 * 3. Pojo 방식응ㄹ 사용하기 위한
 * 	  cglib.jar 파일 maven으로 가져오기 -configuration 사용하기 위해
 *    context:annotationconfig 태그 설정(servlet-context.xml에서 설정함)
 * 
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	
		return "home";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
	
		return "insert";
	}
	@RequestMapping(value = "/bb", method = RequestMethod.GET)
	public String bb(Model model) {
	
		return "bb";
	}
	@RequestMapping(value = "/cc", method = RequestMethod.GET)
	@ResponseBody
	public String cc(Model model) {
	
		return "cc";
	}
	@RequestMapping(value = "/insertproc", method = RequestMethod.GET)
	public String insertproc(Model model) {
	
		return "insertproc";
	}
	
	
}
