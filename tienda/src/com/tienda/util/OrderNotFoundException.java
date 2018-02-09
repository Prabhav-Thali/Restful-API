package com.tienda.util;

import com.tienda.bean.ExceptionMessage;

public class OrderNotFoundException extends TiendaException {
	private static final long serialVersionUID = 4174143153994349652L;

	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(ExceptionMessage exceptionMessage) {
		super(exceptionMessage);
	}
}
