package com.spring.ex05;

public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public void listProducts() {
		productDAO.listProducts();
	}
}
