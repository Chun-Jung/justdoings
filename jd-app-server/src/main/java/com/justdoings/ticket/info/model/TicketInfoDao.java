package com.justdoings.ticket.info.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface TicketInfoDao extends CrudRepository<TicketInfo, Integer> {
	/**
	 * 搜尋活動的所有票卷資訊
	 * @param actSeq 活動編號
	 * @return List<TicketInfo>
	 */
	List<TicketInfo> findByActActSeq(Integer actSeq);
}
