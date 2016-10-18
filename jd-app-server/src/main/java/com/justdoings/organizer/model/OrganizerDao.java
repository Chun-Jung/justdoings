package com.justdoings.organizer.model;

public interface OrganizerDao {
	/**
	 * 新增主辦單位
	 * @param org 主辦單位
	 */
	void saveOrUpdate(Organizer org);
	
	/**
	 * 用主辦單位編號搜尋主辦單位
	 * @param orgSeq 主辦單位編號
	 * @return Organizer
	 */
	Organizer findOne(Integer orgSeq);
	
	/**
	 * 刪除主辦單位
	 * @param orgSeq 主辦單位編號
	 */
	void delete(Integer orgSeq);
}
