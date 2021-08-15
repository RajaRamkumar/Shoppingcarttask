package com.pagoNxt.shoppingcart;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {

	@Test
	public void shouldAbleToAddProductToShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product prod = new Product(1L, "I phone", 500D, 4);
		List<Product> listProd = shoppingCart.addProduct(prod, 4);
		Assertions.assertFalse(shoppingCart.isEmpty(listProd));
	}

	@Test
	public void shouldAbleToAddNullProductToShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Exception exception = assertThrows(ProductNotFoundException.class,
				() -> shoppingCart.addProduct(null, 5));
		Assertions.assertEquals("Selected product is empty", exception.getMessage());
	}

	@Test
	public void shouldAbleToAddGreaterQuantityProductToShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product prod = new Product(1L, "I phone", 500D, 4);
		Exception exception = assertThrows(ProductNotFoundException.class,
				() -> shoppingCart.addProduct(prod, 5));
		Assertions.assertEquals("Selected Quantity of the product is invalid", exception.getMessage());
	}

	@Test
	public void shouldAbleToRemoveProductToShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product prod1 = new Product(1L, "I phone", 500D, 4);
		Product prod2 = new Product(1L, "Samsung Phone", 400D, 10);
		List<Product> listOfProduct = new ArrayList<Product>();
		listOfProduct.add(prod1);
		listOfProduct.add(prod2);
		List<Product> pro = shoppingCart.removeProduct(listOfProduct, prod1);
		Assertions.assertEquals(1, pro.size());
	}
	
	@Test
	public void shouldAbleToRemoveSameProductwithDiffQuantityOfProduct() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product prod1 = new Product(1L, "I phone", 500D, 4);
		Product prod2 = new Product(1L, "Samsung Phone", 400D, 10);
		List<Product> listOfProduct = new ArrayList<Product>();
		listOfProduct.add(prod1);
		listOfProduct.add(prod2);
		Product prod3 = new Product(1L, "I phone", 500D, 3);
		List<Product> pro = shoppingCart.removeProduct(listOfProduct, prod3);
		Assertions.assertEquals(2, pro.size());
	}
	
	@Test
	public void shouldAbleToRemoveSameProductwitGreaterQuantityOfProduct() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product prod1 = new Product(1L, "I phone", 500D, 4);
		Product prod2 = new Product(1L, "Samsung Phone", 400D, 10);
		Product prod3 = new Product(1L, "I phone", 500D, 7);
		List<Product> listOfProduct = new ArrayList<Product>();
		listOfProduct.add(prod1);
		listOfProduct.add(prod2);
		Exception exception = assertThrows(ProductNotFoundException.class,
				() -> shoppingCart.removeProduct(listOfProduct, prod3));
		Assertions.assertEquals("Product Quantity is greater than shopping cart product", exception.getMessage());
	}

	@Test
	public void shouldAbleToRemoveInvalidProductToShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product prod1 = new Product(1L, "I phone", 500D, 4);
		Product prod2 = new Product(1L, "Samsung Phone", 400D, 10);
		Product prod3 = new Product(1L, "Moto Phone", 400D, 10);
		List<Product> listOfProduct = new ArrayList<Product>();
		listOfProduct.add(prod1);
		listOfProduct.add(prod2);
		Exception exception = assertThrows(ProductNotFoundException.class,
				() -> shoppingCart.removeProduct(listOfProduct, prod3));
		Assertions.assertEquals("Product is not available in your shopping cart", exception.getMessage());
	}
	
	
	@Test
	public void shouldAbleToRemoveNullProductToShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product prod1 = new Product(1L, "I phone", 500D, 4);
		Product prod2 = new Product(1L, "Samsung Phone", 400D, 10);
		List<Product> listOfProduct = new ArrayList<Product>();
		listOfProduct.add(prod1);
		listOfProduct.add(prod2);
		Exception exception = assertThrows(ProductNotFoundException.class,
				() -> shoppingCart.removeProduct(listOfProduct, null));
		Assertions.assertEquals("Shopping cart or selected product is empty", exception.getMessage());
	}

}
