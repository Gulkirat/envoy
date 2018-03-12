package com.envoydigital.controllers;

import com.envoydigital.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ProductListController {

	@Resource(name="productService")
	private ProductService productService;

	@RequestMapping("/product/list")
	public String getProductListPage(Model model) {
		model.addAttribute("products", productService.getProducts());
		return "productList";
	}

}
