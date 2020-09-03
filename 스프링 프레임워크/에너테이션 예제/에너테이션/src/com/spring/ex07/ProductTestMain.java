package com.spring.ex07;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProductTestMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:product03.xml");
		ProductService service = ctx.getBean(ProductService.class);		
		
		service.listProducts();
	}
}
