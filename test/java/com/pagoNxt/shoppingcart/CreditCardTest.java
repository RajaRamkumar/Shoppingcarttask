package com.pagoNxt.shoppingcart;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreditCardTest {
	
	@Test
	public void shouldAbleToCalculateTotalAmount() {
		CreditCard creditCard = new CreditCard();
		Product prod1 = new Product(1L, "I phone", 500.72D, 4);
		Product prod2 = new Product(1L, "Samsung Phone", 400D, 10);
		List<Product> listOfProduct = new ArrayList<Product>();
		listOfProduct.add(prod1);
		listOfProduct.add(prod2);
		Long value = creditCard.calculateTotalAmount(listOfProduct, CardType.SILVER);
		Assertions.assertEquals(5403, value);
	}
	
	@Test
	public void shouldAbleToCalculateNullProductsTotalAmount() {
		CreditCard creditCard = new CreditCard();
		Exception exception = assertThrows(ProductNotFoundException.class,
				() -> creditCard.calculateTotalAmount(null, CardType.SILVER));
		Assertions.assertEquals("Shopping cart is empty", exception.getMessage());
	}
	
	@Test
	public void shouldAbleToCalculateNullCreditCardType() {
		CreditCard creditCard = new CreditCard();
		Product prod1 = new Product(1L, "I phone", 500.72D, 4);
		Product prod2 = new Product(1L, "Samsung Phone", 400D, 10);
		List<Product> listOfProduct = new ArrayList<Product>();
		listOfProduct.add(prod1);
		listOfProduct.add(prod2);
		Exception exception = assertThrows(ProductNotFoundException.class,
				() -> creditCard.calculateTotalAmount(listOfProduct, null));
		Assertions.assertEquals("CreditCard Type is Empty", exception.getMessage());
	}
	
	

}
