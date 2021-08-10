package com.jh.org2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jh.org2.cls.AA;
import com.jh.org2.cls.BB;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	AA aa;
	
	@Autowired
	BB bb;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		System.out.println("aa.getAa() = "+ aa.getAa());
		
		return "home";
	}
	@RequestMapping(value = "/bb", method = RequestMethod.GET)
	public String bb(Model model, HttpServletRequest req) {
		
		String number = (String) req.getParameter("bb");
		bb.setAa(Integer.parseInt(number));
		
		System.out.println("bb.getAa() = "+ bb.getBb());
		model.addAttribute("bb",bb);
		return "bb";
	}
	
}
