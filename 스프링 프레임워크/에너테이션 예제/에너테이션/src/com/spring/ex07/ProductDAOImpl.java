package com.spring.ex07;

import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl implements ProductDAO {
	@Override
	public void listProducts() {
		System.out.println("ex07.ProductDAOImpl.listProducts 호출");
	}
}
