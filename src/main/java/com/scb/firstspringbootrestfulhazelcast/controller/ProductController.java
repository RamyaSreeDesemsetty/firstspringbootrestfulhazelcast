package com.scb.firstspringbootrestfulhazelcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.firstspringbootrestfulhazelcast.entity.Product;
import com.scb.firstspringbootrestfulhazelcast.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productServiceImpl.getproducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		Product product = productServiceImpl.getProductById(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/name/{pName}")
	public ResponseEntity<Product> getProductByName(@PathVariable String pName) {
		Product product = productServiceImpl.getProductBypName(pName);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product createdProduct = productServiceImpl.createProduct(product);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateProductById(@RequestBody Product product, @PathVariable Long id) {
		productServiceImpl.updateProductById(product, id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	@PutMapping("/name/{pName}")
	public ResponseEntity<Void> updateProductBypName(@RequestBody Product product, @PathVariable String pName) {
		productServiceImpl.updateProductByName(product, pName);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<List<Product>> deleteProductById(@PathVariable Long id) {
		List<Product> products = productServiceImpl.deleteProductById(id);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

}

