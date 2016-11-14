package com.justdoings.organizer.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface OrganizerDao extends CrudRepository<Organizer, Integer> {
}
