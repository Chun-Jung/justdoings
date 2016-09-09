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
		if(entityManager.contains(act)){
			entityManager.merge(act);
		}else{
			act = entityManager.getReference(Act.class, act.getActSeq());
			entityManager.merge(act);
		}
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
	public int countBy(String defaulLink) {
		Query query = entityManager.createQuery("COUNT(a) FROM Act a WHERE a.defalut_link = :defaultLink");
		query.setParameter("defaultLink", defaulLink);
		return (Integer) query.getSingleResult();
	}

}
