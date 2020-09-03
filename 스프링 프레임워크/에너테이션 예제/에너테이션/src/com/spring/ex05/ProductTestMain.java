package com.spring.ex05;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.spring.ex01.PersonService;
import com.spring.ex03.MemberService;

public class ProductTestMain {
	public static void main(String[] args) {
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:product01.xml");
		//BeanFactory ctx = new XmlBeanFactory(new FileSystemResource("product01.xml"));
		//ProductService service = ctx.getBean(ProductService.class);	
		
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("product01.xml"));
		ProductService service = (ProductService) factory.getBean("productService");
		
		service.listProducts();
	}
}
