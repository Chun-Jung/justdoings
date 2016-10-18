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
	public void saveOrUpdate(Organizer org) {
		if (org.getOrgSeq() == null) {
			entityManager.persist(org);
		} else if (!entityManager.contains(org)) {
			entityManager.merge(org);
		}
	}

	@Override
	public Organizer findOne(Integer orgSeq) {
		return entityManager.find(Organizer.class, orgSeq);
	}

	@Override
	public void delete(Integer orgSeq) {
		Organizer org = findOne(orgSeq);
		if(org != null){
			entityManager.remove(org);
		}
	}

}
