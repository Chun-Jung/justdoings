package com.justdoings.organizer.model;

public interface OrganizerService {
	/**
	 * 新增主辦單位
	 * @param org 主辦單位
	 */
	void insert(Organizer org);
	
	/**
	 * 用主辦單位編號搜尋主辦單位
	 * @param orgSeq 主辦單位編號
	 * @return Organizer
	 */
	Organizer findBy(Integer orgSeq);
	
	/**
	 * 更新主辦單位
	 * @param org 主辦單位
	 */
	void update(Organizer org);

	/**
	 * 刪除主辦單位
	 * @param orgSeq 主辦單位編號
	 */
	void delete(Integer orgSeq);
	
	/**
	 * 刪除主辦單位
	 * @param org 主辦單位編號封裝物件
	 */
	void delete(Organizer org);
}
