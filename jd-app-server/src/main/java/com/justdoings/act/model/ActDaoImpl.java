package com.justdoings.act.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public void insert(Act act) {
		entityManager.persist(act);
	}
	
	@Override
	public Act findBy(Integer actSeq) {
		return entityManager.find(Act.class, actSeq);
	}

	@Override
	public void update(Act act) {
		entityManager.merge(act);
	}

	@Override
	public void delete(Act act) {
		if(entityManager.contains(act)){
			entityManager.remove(act);
		}else{
			act = entityManager.getReference(Act.class, act.getActSeq());
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
