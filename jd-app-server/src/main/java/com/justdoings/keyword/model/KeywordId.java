package com.justdoings.keyword.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class KeywordId implements Serializable {
	/** 字詞 */
	private String word;

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
