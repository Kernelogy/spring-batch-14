package com.edex.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edex.ecommerce.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
