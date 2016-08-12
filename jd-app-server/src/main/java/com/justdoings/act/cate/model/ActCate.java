package com.justdoings.act.cate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActCate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/** 分類編號 */
	private Integer actCateSeq;
	
	/** 分類名稱 */
	private String name;

	public Integer getActCateSeq() {
		return actCateSeq;
	}

	public void setActCateSeq(Integer actCateSeq) {
		this.actCateSeq = actCateSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
