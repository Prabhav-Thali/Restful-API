package com.tienda.util;

import com.tienda.bean.ExceptionMessage;


public class ProductNotFoundException extends TiendaException {
	
	private static final long serialVersionUID = -4490882794182328862L;

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(ExceptionMessage exceptionMessage) {
		super(exceptionMessage);
	}
}
