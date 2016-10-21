package com.justdoings.ticket.order.model;

import java.util.List;

public interface TicketOrderService {
	/**
	 * 新增或儲存票卷訂單
	 * @param order 票卷訂單
	 */
	void saveOrUpdate(TicketOrder order);
	
	/**
	 * 搜尋票卷訂單
	 * @param ordSeq 訂單編號
	 * @return TicketOrder
	 */
	TicketOrder findOne(Integer ordSeq);
	
	/**
	 * 刪除票卷訂單
	 * @param order 票卷訂單
	 */
	void delete(TicketOrder order);

	/**
	 * 刪除票卷訂單
	 * @param ordSeq 訂單編號
	 */
	void delete(Integer ordSeq);
	
	/**
	 * 查詢會員的所有訂單
	 * @param memSeq 會員編號
	 * @return List<TicketOrder>
	 */
	List<TicketOrder> findByMemSeq(Integer memSeq);
}
