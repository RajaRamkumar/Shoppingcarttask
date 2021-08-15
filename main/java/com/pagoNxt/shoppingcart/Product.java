package com.pagoNxt.shoppingcart;

/**
 * Product 
 * @author RAM
 *
 */
public class Product {
	
	private Long prodId;
	private String name;
	private Double price;
	private Integer quantity;
	
	public Product(Long prodId, String name, Double price, Integer quantity) {
		super();
		this.prodId = prodId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Long getProdId() {
		return prodId;
	}
	public String getName() {
		return name;
	}
	public Double getPrice() {
		return price;
	}
	public Integer getQuantity() {
		return quantity;
	}
}

