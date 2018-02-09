package com.tienda.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="link")
public class Link {

	private String href,rel,type;
	
	public Link() {
	super();
		// TODO Auto-generated constructor stub
	}

	public Link(String href, String rel, String type) {
		super();
		this.href = href;
		this.rel = rel;
		this.type = type;
	}

	@XmlAttribute
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	@XmlAttribute
	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}
	@XmlAttribute
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	 
}
