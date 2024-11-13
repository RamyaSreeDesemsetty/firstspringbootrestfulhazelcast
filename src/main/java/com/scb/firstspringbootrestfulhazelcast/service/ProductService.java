package com.scb.firstspringbootrestfulhazelcast.service;

import java.util.List;

import com.scb.firstspringbootrestfulhazelcast.entity.Product;

public interface ProductService {
	public List<Product> getproducts();

	public Product getProductById(long id);

	public Product getProductBypName(String pName);

	public Product createProduct(Product product);

	public void updateProductById(Product product, Long id);

	public void updateProductBypName(Product product, String pName);

	public List<Product> deleteProductById(Long proid);
}
