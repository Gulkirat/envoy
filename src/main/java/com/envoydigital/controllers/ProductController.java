package com.envoydigital.controllers;

import com.envoydigital.form.ProductForm;
import com.envoydigital.model.Product;
import com.envoydigital.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
	@RequestMapping(method = RequestMethod.POST)
	public String saveProductChanges(Model model, ProductForm form) {
		Product product = new Product();
		product.setDescription(form.getDescription());
		product.setId(form.getId());
//		productService.save(product);
		setUpPage(model, product.getId());
		return "productEdit";
	}

	private void setUpPage(Model model, Long productId) {
		model.addAttribute(PRODUCT, productService.getProductForId(productId));
	}

}
