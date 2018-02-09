package com.tienda.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product")
public class Product {

	private int productId;
	private String code, name, description;
	private int price;

	public Product() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Product(int productId, String code, String name, String description,
			int price) {
		super();
		this.productId = productId;
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
