package com.pagoNxt.shoppingcart;

/**
 * enum cardType
 * @author RAM
 *
 */
public enum CardType {
	GOLD("Gold Card", 20),
	SILVER("Silver Card", 10),
	NORMAL("Normal Card", 0);
	
	private String cardType;
	private Integer discount;

	CardType(final String cardType, final Integer discount) {
		this.cardType = cardType;
		this.discount = discount;
	}
	
	public String getCardType() {
		return cardType;
	}
	
	public Integer getDisCount() {
		return discount;
	}
	
}
