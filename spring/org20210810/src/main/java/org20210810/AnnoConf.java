package org20210810;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoConf {
	@Bean
	public AA aa() {
		return new AA();
	}
	@Bean
	public BB bb() {
		return new BB();
	}
	@Bean
	public Lib lib() {
		return new Lib();
	}
}
