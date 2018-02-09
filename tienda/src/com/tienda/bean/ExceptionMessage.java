package com.tienda.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="exception-message")
public class ExceptionMessage {

	public String message;
	
	public ExceptionMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
