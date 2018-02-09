package com.tienda.util;

import com.tienda.bean.ExceptionMessage;


public class WishlistNotFoundException extends TiendaException {

	private static final long serialVersionUID = 4589921570248464728L;

	public WishlistNotFoundException() {
		super();
	}

	public WishlistNotFoundException(ExceptionMessage exceptionMessage) {
		super(exceptionMessage);
	}
}
