package com.justdoings.act.cate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "act_cate")
public class ActCate {
	/** 活動分類編號 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "act_cate_seq")
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
