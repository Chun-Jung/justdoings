package com.justdoings.act.loc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "act_loc")
public class ActLoc {
	/** 活動地區編號 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "act_loc_seq")
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
