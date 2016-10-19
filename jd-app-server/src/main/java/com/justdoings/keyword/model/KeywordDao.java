package com.justdoings.keyword.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface KeywordDao extends CrudRepository<Keyword, KeywordId> {
	/**
	 * 找出特定字詞的關鍵字
	 * @param word 字詞
	 * @return List<Keyword>
	 */
	List<Keyword> findByWord(String word);
}
