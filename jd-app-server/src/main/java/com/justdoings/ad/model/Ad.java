package com.justdoings.ad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.justdoings.act.model.Act;

@Entity
@Table
public class Ad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ad_seq")
	/** 輪播編號 */
	private Integer adSeq;
	
	@ManyToOne
	@JoinColumn(name="actSeq")
	/** 活動編號 */
	private Act act;

	@Column(name = "ad_url")
	/** 活動網址 */
	private String adUrl;

	public Integer getAdSeq() {
		return adSeq;
	}

	public void setAdSeq(Integer adSeq) {
		this.adSeq = adSeq;
	}

	public String getAdUrl() {
		return adUrl;
	}

	public void setAdUrl(String adUrl) {
		this.adUrl = adUrl;
	}

	public Act getAct() {
		return act;
	}

	public void setAct(Act act) {
		this.act = act;
	}
	
}
