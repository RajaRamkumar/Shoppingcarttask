package com.pagoNxt.shoppingcart;

import java.util.List;
/**
 * CreditCard business logic implementation
 * @author RAM
 *
 */
public class CreditCard implements Card {

	public Long calculateTotalAmount(List<Product> productList, CardType cardType) {
		if (null != productList && null != cardType) {
			Double total = 0.0D;
			Double discount = 0.0D;
			for (Product product : productList) {
				total += product.getPrice() * product.getQuantity();
			}
			discount = (total * cardType.getDisCount()) / 100;
			return Math.round(total - discount);
		} else if (null == cardType) {
			throw new ProductNotFoundException("CreditCard Type is Empty"); 
		} else {
			throw new ProductNotFoundException("Shopping cart is empty");
		}
	}

}
