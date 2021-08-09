package com.jh.org1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jh.org1.cls.AA;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	/*
	 * web.xml���뿡
	 * servlet-context.xml ������ �д°� ����Ǿ����ְ�
	 * 
	 * InternalResourceViewResolver
	 * WEB-INF/view/
	 * 
	 * jsp�� ����*/
	
	@Autowired
	AA aa;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		
		model.addAttribute("index1", "aaa");
		model.addAttribute("index2", "bbb");
		System.out.println(aa.getAaa());
		
		return "index";
	}
	
}
