package com.tienda.util;

import javax.xml.bind.annotation.XmlElementRef;

import com.tienda.bean.ExceptionMessage;

public class TiendaException extends Exception {

	private static final long serialVersionUID = 1666497646172567401L;
	
	private ExceptionMessage exceptionMessage;

	public TiendaException() {
		super();
	}

	public TiendaException(ExceptionMessage exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}

	@XmlElementRef
	public ExceptionMessage getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(ExceptionMessage exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		//return super.fillInStackTrace();
		return this;
	}
}
