package com.justdoings.guest.model;

import java.util.List;

public interface GuestService {
	/**
	 * 儲存或更新活動嘉賓
	 * @param guest 活動嘉賓
	 */
	void saveOrUpdate(Guest guest);
	
	/**
	 * 刪除活動嘉賓
	 * @param guest 活動嘉賓
	 */
	void delete(Guest guest);
	
	/**
	 * 刪除活動嘉賓
	 * @param guestSeq 活動嘉賓編號
	 */
	void delete(Integer guestSeq);
	
	/**
	 * 找出該活動的所有嘉賓
	 * @param actSeq 活動編號
	 * @return List<Guest>
	 */
	List<Guest> findByActSeq(Integer actSeq);
}
