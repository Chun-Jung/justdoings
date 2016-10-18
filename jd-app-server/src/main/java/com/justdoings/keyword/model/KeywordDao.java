package com.justdoings.keyword.model;

import java.util.List;

public interface KeywordDao {

	/**
	 * 新增關鍵字查詢紀錄
	 * @param keyword 字詞封裝物件
	 */
	void save(Keyword keyword);
	
	/**
	 * 刪除關鍵字查詢紀錄
	 * @param keywordId 關鍵字PK
	 */
	void delete(KeywordId keywordId);
	
	/**
	 * 找出特定字詞的關鍵字
	 * @param word 字詞
	 * @return List<Keyword>
	 */
	List<Keyword> findAllBy(String word);
}
