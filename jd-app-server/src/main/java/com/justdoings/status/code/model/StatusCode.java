package com.justdoings.status.code.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "status_code")
@IdClass(StatusCodeId.class)
public class StatusCode {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "status_seq")
	/** 狀態碼編號 */
	private Integer statusSeq;
	
	@Id
	/** 狀態碼代號 */
	private Integer code;
	
	/** 狀態名稱 */
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
	
	public String getLabel(){
		return this.code + "-" + this.value;
	}
	
}
