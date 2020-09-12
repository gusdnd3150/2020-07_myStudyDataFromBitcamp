package com.myspring.pro27.rest.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.lang.jstl.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/*")
public class TestController {
	
	
	 @RequestMapping("/test/*") public String hello() { return
	"Hello REST 이것은 뷰값이 아닌 데이터 값이다!"; }
	 
	
	@RequestMapping("/main/*")
	public MemberVO member() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setPwd("1234");
		vo.setName("홍길동");
		vo.setEmail("ddd@.co");
		return vo;
	}

	
	
	
	@RequestMapping(value = "/notice/{num}", method =RequestMethod.GET)
	public int notice(@PathVariable("num") int num) throws Exception {
		return num;
		
	}

}
