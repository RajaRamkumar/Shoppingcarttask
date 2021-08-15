package com.pagoNxt.shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 * Business logic for Shopping Cart
 * 
 * @author RAM
 *
 */
public class ShoppingCart {

	/**
	 * Add Product to the shopping cart
	 * 
	 * @param product  as product
	 * @param quantity as quantity
	 * @return list of products
	 */
	public List<Product> addProduct(Product product, int quantity) {
		if (null != product) {
			if (quantity > 0 && product.getQuantity() >= quantity) {
				List<Product> listOfProduct = new ArrayList<Product>();
				listOfProduct.add(product);
				return listOfProduct;
			} else {
				throw new ProductNotFoundException("Selected Quantity of the product is invalid");
			}
		}
		throw new ProductNotFoundException("Selected product is empty");
	}

	/**
	 * Remove Product to the shopping cart
	 * 
	 * @param productList as list of product
	 * @param product     as product to remove
	 * @return productList
	 */
	public List<Product> removeProduct(List<Product> productList, Product product) {
		if ((null != productList && null != product) && product.getQuantity() > 0) {
			Product validProduct = null;
			for (Product prod : productList) {
				if (prod.getProdId().equals(product.getProdId()) && prod.getName().equals(product.getName())
						&& prod.getPrice().equals(product.getPrice())) {
					validProduct = prod;
				}
			}
			if (null != validProduct) {
				if (validProduct.getQuantity().equals(product.getQuantity())) {
					productList.remove(validProduct);
					return productList;
				} else if (validProduct.getQuantity() >= product.getQuantity()) {
					productList.remove(validProduct);
					Product product2 = new Product(validProduct.getProdId(), validProduct.getName(),
							validProduct.getPrice(), validProduct.getQuantity() - product.getQuantity());
					productList.add(product2);
					return productList;
				} else {
					throw new ProductNotFoundException("Product Quantity is greater than shopping cart product");
				}
			} else {
				throw new ProductNotFoundException("Product is not available in your shopping cart");
			}
		}
		throw new ProductNotFoundException("Shopping cart or selected product is empty");
	}

	/**
	 * isEmpty
	 * @param productList as input
	 * @return true or false
	 */
	public boolean isEmpty(List<Product> productList) {
		return null == productList || productList.isEmpty();
	}

}
