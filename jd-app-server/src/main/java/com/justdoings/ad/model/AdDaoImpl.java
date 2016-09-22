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
	public void insert(Ad ad) {
		entityManager.persist(ad);
	}

	@Override
	public Ad findBy(Integer adSeq) {
		Ad result = entityManager.find(Ad.class, adSeq);
		return result;
	}

	@Override
	public void update(Ad ad) {
		entityManager.merge(ad);
	}

	@Override
	public void delete(Ad ad) {
		if(entityManager.contains(ad)){
			entityManager.remove(ad);
		}else{
			ad = entityManager.getReference(Ad.class, ad.getAdSeq());
			entityManager.remove(ad);
		}
	}

}
