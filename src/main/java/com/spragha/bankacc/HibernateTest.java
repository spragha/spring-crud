package com.spragha.bankacc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:business-config.xml");
		ctx.load("classpath:datasource-config.xml");
		ctx.load("classpath:data-access.properties");
		ctx.refresh();
		
		ctx.getBean("object", Object.class);

	}

}
