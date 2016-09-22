package com.justdoings.tag.model;

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
@NamedQueries({
	@NamedQuery(name="Tag.findByActSeq", query="SELECT COUNT(a) FROM Act a WHERE a.shortLink = :shortLink")
})
@Table
public class Tag {
	/** 標籤編號 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tag_seq")
	private Integer tagSeq;
	
	/** 活動編號 */
	@ManyToOne
	@JoinColumn(name="act_Seq")
	private Act act;
	
	/** 標籤名稱 */
	private String name;

	public Integer getTagSeq() {
		return tagSeq;
	}

	public void setTagSeq(Integer tagSeq) {
		this.tagSeq = tagSeq;
	}

	public Act getAct() {
		return act;
	}

	public void setAct(Act act) {
		this.act = act;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
