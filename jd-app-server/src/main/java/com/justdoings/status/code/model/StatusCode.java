package com.justdoings.status.code.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StatusCode {
	@Id
	/** ª¬ºA½X½s¸¹ */
	private Integer statusSeq;
	
	@Id
	/** ª¬ºA½X¥N¸¹ */
	private Integer code;
	
	/** ª¬ºA¦WºÙ */
	private String value;

	public Integer getStatusSeq() {
		return statusSeq;
	}

	public void setStatusSeq(Integer statusSeq) {
		this.statusSeq = statusSeq;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
