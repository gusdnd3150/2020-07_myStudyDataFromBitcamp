package com.spring.ex06;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProductTestMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:product02.xml");
		ProductService service = ctx.getBean(ProductService.class);		
		
		service.listProducts();
	}
}
