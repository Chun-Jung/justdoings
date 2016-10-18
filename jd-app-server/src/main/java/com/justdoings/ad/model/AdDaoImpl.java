package com.justdoings.ad.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("adDao")
@Transactional(propagation = Propagation.MANDATORY)
public class AdDaoImpl implements AdDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveOrUpdate(Ad ad) {
		if(ad.getAdSeq() == null){
			entityManager.persist(ad);
		}else if(!entityManager.contains(ad)){
			entityManager.merge(ad);
		}
	}

	@Override
	public Ad findOne(Integer adSeq) {
		return entityManager.find(Ad.class, adSeq);
	}

	@Override
	public void delete(Integer adSeq) {
		Ad ad = entityManager.find(Ad.class, adSeq);
		if(ad != null){
			entityManager.remove(ad);
		}
	}

}
