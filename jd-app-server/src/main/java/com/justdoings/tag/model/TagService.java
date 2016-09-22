package com.justdoings.tag.model;

import java.util.List;

public interface TagService {
	/**
	 * 新增標籤
	 * @param tag 標籤
	 */
	void insert(Tag tag);
	
	/**
	 * 搜尋標籤
	 * @param actSeq 活動編號
	 * @return List<Tag> 標籤
	 */
	List<Tag> findBy(Integer actSeq);
	
	/**
	 * 更新標籤
	 * @param tag 標籤
	 */
	void update(Tag tag);
	
	/**
	 * 刪除標籤
	 * @param tag 標籤
	 */
	void delete(Tag tag);
	
	/**
	 * 依據活動編號刪除標籤
	 * @param actSeq 活動編號
	 * @return int 刪除比數
	 */
	int deleteBy(Integer actSeq);
}
