package com.justdoings.keyword.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@NamedQueries({
		@NamedQuery(name = "Keyword.findByTsRange", query = "SELECT K from Keyword K WHERE K.queryTs >= :startTs AND K.queryTs <= :endTs "),
		@NamedQuery(name = "Keyword.findAllByWord", query = "SELECT K from Keyword K WHERE K.word = :word")})
@Table
@IdClass(KeywordId.class)
public class Keyword implements Serializable {
	@Id
	/** 字詞 */
	private String word;

	@Id
	@Column(name = "query_ts")
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
