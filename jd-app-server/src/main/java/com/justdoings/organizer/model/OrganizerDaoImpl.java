package com.justdoings.organizer.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("organizerDao")
@Transactional(propagation = Propagation.MANDATORY)
public class OrganizerDaoImpl implements OrganizerDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(Organizer org) {
		entityManager.persist(org);
	}

	@Override
	public Organizer findBy(Integer orgSeq) {
		return entityManager.find(Organizer.class, orgSeq);
	}

	@Override
	public void update(Organizer org) {
		entityManager.merge(org);
	}

	@Override
	public void delete(Organizer org) {
		if(entityManager.contains(org)){
			entityManager.remove(org);
		}else{
			org = entityManager.getReference(Organizer.class, org.getOrgSeq());
			entityManager.remove(org);
		}
	}

}
