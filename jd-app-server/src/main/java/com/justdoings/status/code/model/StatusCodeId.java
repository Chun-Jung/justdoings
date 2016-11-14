package com.justdoings.status.code.model;

import java.io.Serializable;

public class StatusCodeId implements Serializable {
	
	private Integer statusSeq;
	
	private Integer code;

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
}
