package com.envoydigital.controllers;

import com.envoydigital.form.ProductForm;
import com.envoydigital.model.Product;
import com.envoydigital.populator.ProductPopulator;
import com.envoydigital.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("/product/edit/{id}")
public class ProductController {

    private static final String PRODUCT = "product";

    @Resource(name = "productService")
    private ProductService productService;

    @Resource(name = "productPopulator")
    private ProductPopulator productPopulator;

    @RequestMapping(method = RequestMethod.GET)
    public String getProductEditPage(Model model, @PathVariable(name = "id") Long productId) {
        setUpPage(model, productId);
        return "productEdit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveProductChanges(Model model, ProductForm productForm) {
        Product product = productService.getProductForId(productForm.getId());
        product = productPopulator.populate(productForm, product);

        productService.save(product);
        setUpPage(model, product.getId());
        return "productEdit";
    }

    private void setUpPage(Model model, Long productId) {
        model.addAttribute(PRODUCT, productService.getProductForId(productId));
    }

}
