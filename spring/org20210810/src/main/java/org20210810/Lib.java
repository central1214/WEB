package org20210810;

import org.springframework.beans.factory.annotation.Autowired;


public class Lib {
	
	@Autowired
	AA aa;
	
	@Autowired(required = false)
	BB bb;
	
	
	public void print() {
		aa.doAA();
	}
	
}
