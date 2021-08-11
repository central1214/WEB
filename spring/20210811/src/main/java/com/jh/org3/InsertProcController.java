package com.jh.org3;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jh.org3.db.DBManager;

@Controller
public class InsertProcController {

	@Autowired
	DBManager dbm;
	
	@RequestMapping(value = "/insertproc", method = RequestMethod.POST)
	public String insertproc(Model model, String para1, String para2) {
		dbm.insert(para1, para2);
		return "insertproc";
	}
}
