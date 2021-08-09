package org20210809;

import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlMain2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext gxac = new GenericXmlApplicationContext("classpath:XmlConf2.xml");
		
		A a1 = gxac.getBean(A.class);
		A a2 = gxac.getBean(A.class);
		B b = gxac.getBean(B.class);
		System.out.println(a2.getAa());
		System.out.println(b.getA().getAa());
		
		
		
		
	}

}
