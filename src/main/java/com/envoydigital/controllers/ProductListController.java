package com.envoydigital.controllers;

import com.envoydigital.service.ProductService;
import com.sun.xml.internal.ws.util.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ProductListController {

	@Resource(name="productService")
	private ProductService productService;

	@RequestMapping("/product/list")
	public String getProductListPage(Model model, HttpSession session) {
		model.addAttribute("products", productService.getProducts());
		session.setAttribute("currency", "GBP");
		return "productList";
	}

}
