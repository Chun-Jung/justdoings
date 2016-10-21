package com.justdoings.ticket.order.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface TicketOrderDao extends CrudRepository<TicketOrder, Integer> {
	/**
	 * 查詢會員的所有訂單
	 * @param memSeq 會員編號
	 * @return List<TicketOrder>
	 */
	List<TicketOrder> findByMemSeq(Integer memSeq);
}
