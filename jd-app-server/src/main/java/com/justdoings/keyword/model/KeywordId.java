package com.justdoings.keyword.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class KeywordId implements Serializable {
	/** 字詞 */
	private String word;

	/** 查詢時戳 */
	private Timestamp queryTs;
}
