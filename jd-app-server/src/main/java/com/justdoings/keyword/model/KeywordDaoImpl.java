package com.justdoings.keyword.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("keywordDao")
@Transactional(propagation = Propagation.MANDATORY)
public class KeywordDaoImpl implements KeywordDao {
	
	protected static final String FIND_ALL_BY_WORD_NAME_QUERY = "Keyword.findAllByWord";
	protected static final String FIND_BY_TS_RANGE_NAME_QUERY = "Keyword.findByTsRange";

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Keyword keyword) {
		entityManager.persist(keyword);
	}

	@Override
	public void delete(KeywordId keywordId) {
		Keyword keyword = entityManager.find(Keyword.class, keywordId);
		if(keyword != null){
			entityManager.remove(keyword);
		}
	}

	@Override
	public List<Keyword> findAllBy(String word) {
		TypedQuery<Keyword> query = entityManager.createNamedQuery(FIND_ALL_BY_WORD_NAME_QUERY, Keyword.class);
		query.setParameter("word", word);
		return query.getResultList();
	}

}
