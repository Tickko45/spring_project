package com.yuttachak.vaccinesystem15.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yuttachak.vaccinesystem15.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("SELECT p FROM Product p WHERE CONCAT(p.product_name,' ',p.product_description,' ',p.product_price) LIKE %?1%")
	public List<Product> search(String keyword);
}
