package com.justdoings.ticket.info.model;

import java.util.List;

public interface TicketInfoService {
	/**
	 * 新增或修改票卷資訊
	 * @param ticketInfo 票卷資訊
	 */
	void saveOrUpdate(TicketInfo ticketInfo);
	
	/**
	 * 用PK查詢票卷資訊
	 * @param ticInfoSeq 票卷資訊編號
	 * @return TicketInfo
	 */
	TicketInfo findOne(Integer ticInfoSeq);
	
	/**
	 * 刪除票卷資訊
	 * @param ticketInfo 票卷資訊
	 */
	void delete(TicketInfo ticketInfo);
	
	/**
	 * 刪除票卷資訊
	 * @param ticInfoSeq 票卷資訊編號
	 */
	void delete(Integer ticInfoSeq);
	
	/**
	 * 搜尋活動的所有票卷資訊
	 * @param actSeq 活動編號
	 * @return List<TicketInfo>
	 */
	List<TicketInfo> findByActActSeq(Integer actSeq);
}
