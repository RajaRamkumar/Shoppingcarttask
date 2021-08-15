package com.pagoNxt.shoppingcart;

/**
 * CustomException
 * @author RAM
 *
 */
public class ProductNotFoundException extends RuntimeException{

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}

	
}
