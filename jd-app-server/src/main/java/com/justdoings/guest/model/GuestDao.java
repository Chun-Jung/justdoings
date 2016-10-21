package com.justdoings.guest.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface GuestDao extends CrudRepository<Guest, Integer> {
	/**
	 * 找出該活動的所有嘉賓
	 * @param actSeq 活動編號
	 * @return List<Guest>
	 */
	List<Guest> findByActSeq(Integer actSeq);
}
