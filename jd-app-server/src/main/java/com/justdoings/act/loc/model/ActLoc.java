package com.justdoings.act.loc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActLoc {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/** 地區編號 */
	private Integer actLocSeq;
	
	/** 地區名稱 */
	private String name;

	public Integer getActLocSeq() {
		return actLocSeq;
	}

	public void setActLocSeq(Integer actLocSeq) {
		this.actLocSeq = actLocSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
