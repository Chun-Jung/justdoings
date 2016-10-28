package com.justdoings.ticket.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface TicketDao extends CrudRepository<Ticket, Integer> {
	/**
	 * 查詢該訂單所有的票卷
	 * @param ordSeq 訂單編號
	 * @return List<Ticket>
	 */
	List<Ticket> findByTicOrdOrdSeq(Integer ordSeq);
	
	/**
	 * 查詢該票卷資訊所有票卷
	 * @param ticInfoSeq 票卷資訊編號
	 * @return List<Ticket>
	 */
	List<Ticket> findByTicInfoTicInfoSeq(Integer ticInfoSeq);
}
