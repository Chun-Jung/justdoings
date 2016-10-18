package com.justdoings.act.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("actDao")
@Transactional(propagation = Propagation.MANDATORY)
public class ActDaoImpl implements ActDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveOrUpdate(Act act) {
		if (act.getActSeq() == null) {
			entityManager.persist(act);
		} else if (!entityManager.contains(act)) {
			entityManager.merge(act);
		}
	}

	@Override
	public Act findOne(Integer actSeq) {
		return entityManager.find(Act.class, actSeq);
	}

	@Override
	public void delete(Integer actSeq) {
		Act act = findOne(actSeq);
		if(act != null){
			entityManager.remove(act);
		}
	}

	@Override
	public Long countBy(String shortLink) {
		TypedQuery<Long> query = entityManager.createNamedQuery("Act.countByShortLink", Long.class);
		query.setParameter("shortLink", shortLink);
		return query.getSingleResult();
	}

}
