package com.justdoings.act.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface ActDao extends CrudRepository<Act, Integer> {
	/**
	 * 查詢短連結比數
	 * @param shortLink 短連結
	 * @return Long
	 */
	Long countByShortLink(String shortLink);
}
