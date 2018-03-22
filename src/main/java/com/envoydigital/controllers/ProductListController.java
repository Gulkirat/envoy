package com.envoydigital.controllers;

import com.envoydigital.service.CurrencyService;
import com.envoydigital.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/product/list")
public class ProductListController {

	private static final String CURRENCY = "currency";
	private static final String GBP = "GBP";
	private static final String PRODUCTS = "products";
	private static final String CURRENCIES = "currencies";

	@Resource(name="productService")
	private ProductService productService;

	@Resource(name="currencyService")
	private CurrencyService currencyService;

	@RequestMapping(method = RequestMethod.GET)
	public String getProductListPage(Model model, HttpSession session) {
		setUpPage(model, session, null);
		return "productList";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String setCurrency(Model model, HttpSession session, @RequestParam(name=CURRENCY) String currency) {
		setUpPage(model, session, currency);
		return "productList";
	}

	private void setUpPage(Model model, HttpSession session, String currency) {
		model.addAttribute(PRODUCTS, productService.getProducts());
		model.addAttribute(CURRENCIES, currencyService.getCurrencies());
		setSessionCurrency(session, currency);
	}

	private void setSessionCurrency(HttpSession session, String currency) {
		if (currency == null && session.getAttribute(CURRENCY) == null) {
			session.setAttribute(CURRENCY, GBP);
		} else if (currency != null){
			session.setAttribute(CURRENCY, currency);
		}
	}

}
