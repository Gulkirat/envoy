package com.envoydigital.form;

public class ProductForm {

	private Long id;
	private String description;
	private String gbp;
	private String eur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public String getGBP() {
		return gbp;
	}

	public void setGBP(String gbp) {
		this.gbp = gbp;
	}

	public String getEUR() {
		return eur;
	}

	public void setEUR(String eur) {
		this.eur = eur;
	}

}
