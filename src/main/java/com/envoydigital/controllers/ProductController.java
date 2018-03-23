package com.envoydigital.controllers;

import com.envoydigital.form.ProductForm;
import com.envoydigital.model.Price;
import com.envoydigital.model.Product;
import com.envoydigital.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

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
	public String saveProductChanges(Model model, ProductForm productForm) {
		Product product = getProductFrom(productForm);

		productService.save(product);
		setUpPage(model, product.getId());
		return "productEdit";
	}

	private Product getProductFrom(ProductForm form) {
		Product product = productService.getProductForId(form.getId());
		product.setName(form.getName());
		product.setDescription(form.getDescription());
		product.setPrices(getPrices(form, product.getPrices()));
		return product;
	}

	private Map<Currency, Price> getPrices(ProductForm form, Map<Currency, Price> prices) {
		setPrice(prices, "GBP", form.getGBP());
		setPrice(prices, "EUR", form.getEUR());
		return prices;
	}

	private void setPrice(Map<Currency, Price> prices, String currencyCode, BigDecimal amount) {
		Currency currency = Currency.getInstance(currencyCode);
		Price price = prices.get(currency);
		price.setAmount(amount);
		prices.put(currency, price);
	}

	private void setUpPage(Model model, Long productId) {
		model.addAttribute(PRODUCT, productService.getProductForId(productId));
	}

}
