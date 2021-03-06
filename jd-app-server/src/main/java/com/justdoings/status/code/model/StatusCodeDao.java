package com.justdoings.status.code.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface StatusCodeDao extends CrudRepository<StatusCode, StatusCodeId> {
}
