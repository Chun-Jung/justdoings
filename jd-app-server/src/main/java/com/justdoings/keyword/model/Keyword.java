package com.justdoings.keyword.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(name = "Keyword.findByTsRange", query = "SELECT K from Keywork K WHERE K.queryTs >= :startTs AND K.queryTs <= :endTs ") })
@Table
public class Keyword {
	@Id
	/** 字詞 */
	private String word;

	@Id
	/** 查詢時戳 */
	private Timestamp queryTs;

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
