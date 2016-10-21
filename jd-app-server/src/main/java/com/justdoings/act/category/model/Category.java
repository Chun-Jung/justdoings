package com.justdoings.act.category.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category {
	/** 活動分類編號 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cate_seq")
	private Integer cateSeq;
	
	/** 分類名稱 */
	private String name;
	
	/** ============== getters and setters ============== */
	
	public Integer getCateSeq() {
		return cateSeq;
	}

	public void setCateSeq(Integer cateSeq) {
		this.cateSeq = cateSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
