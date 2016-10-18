package com.justdoings.tag.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface TagDao extends CrudRepository<Tag, TagId> {
	/**
	 * 搜尋標籤
	 * @param actSeq 活動編號
	 * @return List<Tag> 標籤
	 */
	List<Tag> findByActSeq(Integer actSeq);
	
	/**
	 * 依據活動編號刪除標籤
	 * @param actSeq 活動編號
	 * @return int 刪除比數
	 */
	int deleteByActSeq(Integer actSeq);
}
