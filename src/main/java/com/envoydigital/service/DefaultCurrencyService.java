package com.envoydigital.service;

import com.envoydigital.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;

@Component("currencyService")
@Transactional
public class DefaultCurrencyService implements CurrencyService {

	@Override
	public Iterable<String> getCurrencies() {
		ArrayList<String> currencies = new ArrayList<>();
		currencies.add("EUR");
		currencies.add("GBP");
		return currencies;
	}

}