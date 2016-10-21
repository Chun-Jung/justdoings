package com.justdoings.keyword.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(name = "Keyword.findByTsRange", query = "SELECT K from Keyword K WHERE K.queryTs >= ?1 AND K.queryTs <= ?2 ")
		})
@Table
@IdClass(KeywordId.class)
public class Keyword {
	/** 字詞 */
	@Id
	private String word;

	/** 查詢時戳 */
	@Id
	@Column(name = "query_ts")
	private Timestamp queryTs;
	
	/** ============== getters and setters ============== */
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Timestamp getQueryTs() {
		return queryTs;
	}

	public void setQueryTs(Timestamp queryTs) {
		this.queryTs = queryTs;
	}
}
