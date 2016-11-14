package com.justdoings.tag.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table
@IdClass(TagId.class)
public class Tag {
	/** 活動編號 */
	@Id
	@Column(name="act_seq")
	private Integer actSeq;
	
	/** 標籤名稱 */
	@Id
	private String name;

	/** ============== getters and setters ============== */

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
