package com.envoydigital.controllers;

import com.envoydigital.service.CurrencyService;
import com.envoydigital.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/product/edit/{id}")
public class ProductController {

	private static final String PRODUCT = "product";

	@Resource(name="productService")
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public String getProductEditPage(Model model, @PathVariable(name="id") Long productId) {
		setUpPage(model, productId);
		return "productEdit";
	}

	private void setUpPage(Model model, Long productId) {
		model.addAttribute(PRODUCT, productService.getProductForId(productId));
	}

}
