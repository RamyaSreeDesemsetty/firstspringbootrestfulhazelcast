package com.scb.firstspringbootrestfulhazelcast.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.firstspringbootrestfulhazelcast.entity.Product;
import com.scb.firstspringbootrestfulhazelcast.repository.ProductRepository;

@Service
public class ProductServiceImpl {
	@Autowired
	ProductRepository proRepo;

//getallproducts
	public List<Product> getproducts() {
		return proRepo.findAll();
	}

	// get product by id
	public Product getProductById(long id) {
		Optional<Product> product = proRepo.findById(id);
		return product.orElse(null);
	}

// get product by name
	public Product getProductBypName(String pName) {
		Optional<Product> productName = proRepo.findBypName(pName);
		return productName.orElse(null);
	}



// create product
	public Product createProduct(Product product) {
		return proRepo.save(product);
	}

//update product by id
	public void updateProductById(Product product, Long id) {
		Optional<Product> existProduct = proRepo.findById(id);
		if (existProduct.isPresent()) {
			Product existingProduct = existProduct.get();
			existingProduct.setpName(product.getpName());
			existingProduct.setPrice(product.getPrice());
			proRepo.save(existingProduct);
		}
	}
		// update product by name
		public void updateProductByName(Product product, String pName) {
			Optional<Product> existProd = proRepo.findBypName(pName);
	if(existProd.isPresent()) {
		Product existingProd = existProd.get();
		existingProd.setpName(product.getpName());
		existingProd.setPrice(product.getPrice());
		proRepo.save(existingProd);
	}


}
		// delete product by id
		public List<Product> deleteProductById(Long proid) {
			proRepo.deleteById(proid);
			return getproducts();
		}

	}

