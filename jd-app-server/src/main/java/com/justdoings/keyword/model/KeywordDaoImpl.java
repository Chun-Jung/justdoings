package com.justdoings.keyword.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("keywordDao")
@Transactional(propagation = Propagation.MANDATORY)
public class KeywordDaoImpl implements KeywordDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(Keyword keyword) {
		entityManager.persist(keyword);
	}

	@Override
	public void delete(Keyword keyword) {
		if(entityManager.contains(keyword)){
			entityManager.remove(keyword);
		}else{
			KeywordId keywordId = new KeywordId();
			BeanUtils.copyProperties(keyword, keywordId);
			keyword = entityManager.getReference(Keyword.class, keywordId);
			entityManager.remove(keyword);
		}
	}

	@Override
	public List<Keyword> getAllBy(String word) {
		Query query = entityManager.createNamedQuery("Keyword.findAllByWord");
		query.setParameter("word", word);
		return query.getResultList();
	}

}
