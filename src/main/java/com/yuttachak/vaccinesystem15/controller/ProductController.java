package com.yuttachak.vaccinesystem15.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuttachak.vaccinesystem15.entity.Product;
import com.yuttachak.vaccinesystem15.service.ProductService;


@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String ListProduct(Model model, @Param("keyword") String keyword) {
		List<Product> theProduct = productService.listAll(keyword);
		model.addAttribute("product", theProduct);
		model.addAttribute("keyword", keyword);
		
		return "/product/list-product";
	}
}
