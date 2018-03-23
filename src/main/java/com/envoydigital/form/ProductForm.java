package com.envoydigital.form;

import java.math.BigDecimal;

public class ProductForm {

	private Long id;
    private String name;
    private String description;
    private BigDecimal gbp;
    private BigDecimal eur;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public BigDecimal getGBP() {
		return gbp;
	}

	public void setGBP(BigDecimal gbp) {
		this.gbp = gbp;
	}

	public BigDecimal getEUR() {
		return eur;
	}

	public void setEUR(BigDecimal eur) {
		this.eur = eur;
	}

}
