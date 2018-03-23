package com.envoydigital.populator;

import com.envoydigital.form.ProductForm;
import com.envoydigital.model.Price;
import com.envoydigital.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;

@Component("productPopulator")
public class ProductPopulator {

    public Product populate(ProductForm form, Product product) {
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
}
