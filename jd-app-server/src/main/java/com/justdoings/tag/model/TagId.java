package com.justdoings.tag.model;

import java.io.Serializable;

public class TagId implements Serializable {
	private Integer actSeq;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getActSeq() {
		return actSeq;
	}
	public void setActSeq(Integer actSeq) {
		this.actSeq = actSeq;
	}

}
