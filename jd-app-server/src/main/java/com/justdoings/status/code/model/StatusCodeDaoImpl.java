package com.justdoings.status.code.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("statusCodeDao")
@Transactional(propagation = Propagation.MANDATORY)
public class StatusCodeDaoImpl implements StatusCodeDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public StatusCode findBy(StatusCodeId primaryKey) {
		return entityManager.find(StatusCode.class, primaryKey);
	}

}
