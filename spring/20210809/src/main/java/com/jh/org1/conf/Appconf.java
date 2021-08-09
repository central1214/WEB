package com.jh.org1.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jh.org1.cls.AA;

@Configuration
public class Appconf {
	
	// import ÀÚµ¿ ctr + shift + o
	@Bean
	public AA aa() {
		AA aa = new AA();
		return aa;
	}

}
