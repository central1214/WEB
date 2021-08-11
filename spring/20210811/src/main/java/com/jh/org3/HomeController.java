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
 * 1. �ڹ� ���� ���߱� 
 * 	  build path
 *    project facets
 *    
 * 2. web.xml j �ҹ��ڸ� �빮�ڷ�
 * 
 * 3. Pojo ������� ����ϱ� ����
 * 	  cglib.jar ���� maven���� �������� -configuration ����ϱ� ����
 *    context:annotationconfig �±� ����(servlet-context.xml���� ������)
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
