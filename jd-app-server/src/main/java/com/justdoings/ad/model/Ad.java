package com.justdoings.ad.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.justdoings.act.model.Act;

@Entity
@NamedQueries(value = {@NamedQuery(name = "findEffectAd", query = "SELECT A FROM Ad A WHERE A.effectBeginDt >= ?1 AND A.effectEndDt <= ?2")})
@Table
public class Ad {
	/** 輪播編號 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ad_seq")
	private Integer adSeq;
	
	/** 活動編號 */
	@ManyToOne
	@JoinColumn(name="act_Seq")
	private Act act;
	
	/** 有效起日 */
	@Column(name = "effect_begin_dt")
	private Date effectBeginDt;
	
	/** 有效迄日 */
	@Column(name = "effect_end_dt")
	private Date effectEndDt;
	
	/** ============== getters and setters ============== */

	public Integer getAdSeq() {
		return adSeq;
	}

	public void setAdSeq(Integer adSeq) {
		this.adSeq = adSeq;
	}

	public Act getAct() {
		return act;
	}

	public void setAct(Act act) {
		this.act = act;
	}

	public Date getEffectBeginDt() {
		return effectBeginDt;
	}

	public void setEffectBeginDt(Date effectBeginDt) {
		this.effectBeginDt = effectBeginDt;
	}

	public Date getEffectEndDt() {
		return effectEndDt;
	}

	public void setEffectEndDt(Date effectEndDt) {
		this.effectEndDt = effectEndDt;
	}
	
}
