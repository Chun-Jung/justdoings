package com.justdoings.ticket.model;

import java.util.List;

public interface TicketService {
	/**
	 * 新增或更新票卷
	 * @param ticket 票卷
	 */
	void saveOrUpdate(Ticket ticket);
	
	/**
	 * 用票卷編號查詢票卷
	 * @param ticketSeq 票卷編號
	 * @return Ticket
	 */
	Ticket findOne(Integer ticketSeq);
	
	/**
	 * 刪除票卷
	 * @param ticket 票卷
	 */
	void delete(Ticket ticket);
	
	/**
	 * 刪除票卷
	 * @param ticketSeq 票卷編號
	 */
	void delete(Integer ticketSeq);
	
	/**
	 * 用訂單查詢所有票卷
	 * @param ordSeq 訂單編號
	 * @return List<Ticket>
	 */
	List<Ticket> findByOrdSeq(Integer ordSeq);
	
	/**
	 * 用票卷資訊查詢所有票卷
	 * @param ticInfoSeq 票卷資訊編號
	 * @return List<Ticket>
	 */
	List<Ticket> findByTicInfoSeq(Integer ticInfoSeq);
	
	/**
	 * 用活動編號查詢所有票卷
	 * @param actSeq 活動編號
	 * @return List<Ticket>
	 */
	List<Ticket> findByActSeq(Integer actSeq);
}
