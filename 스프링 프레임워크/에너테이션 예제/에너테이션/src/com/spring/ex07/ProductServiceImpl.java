package com.spring.ex07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;

	@Autowired
	public void setProductDAO(ProductDAO productDAO) {
		System.out.println("1111111111");
		this.productDAO = productDAO;
	}

	@Override
	public void listProducts() {
		productDAO.listProducts();
	}
}
