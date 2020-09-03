package com.spring.ex03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.spring.ex07.ProductService;

public class MemberTest1 {
	public static void main(String[] args) {
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("member.xml"));
//		MemberService service = (MemberService) factory.getBean("memberService");
//		service.listMembers();
		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:member2.xml");
//		MemberService service = (MemberService) ctx.getBean("memberService");
//		service.listMembers();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:member3.xml");
		MemberService service = (MemberService) ctx.getBean("memberService");
		service.listMembers();		
	}
}
