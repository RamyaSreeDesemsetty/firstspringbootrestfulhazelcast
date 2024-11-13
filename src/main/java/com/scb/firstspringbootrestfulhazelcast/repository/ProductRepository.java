package com.scb.firstspringbootrestfulhazelcast.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scb.firstspringbootrestfulhazelcast.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Cacheable("productcache")
	Optional<Product> findBypName(String pName);


}
