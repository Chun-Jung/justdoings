package com.justdoings.keyword.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Keyword.findByTs", query = "SELECT K from Keywork K WHERE K.queryTs >= :startTs AND K.queryTs <= :endTs ")
})
public class Keyword {
	@Id
	/** ¦rµü */
	private String word;
	
	@Id
	/** ¬d¸ß®ÉÂW */
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
