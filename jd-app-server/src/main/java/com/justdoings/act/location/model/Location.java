package com.justdoings.act.location.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Location {
	/** 活動地區編號 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "loc_seq")
	private Integer locSeq;
	
	/** 地區名稱 */
	private String name;
	
	/** ============== getters and setters ============== */

	public Integer getLocSeq() {
		return locSeq;
	}

	public void setLocSeq(Integer locSeq) {
		this.locSeq = locSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
