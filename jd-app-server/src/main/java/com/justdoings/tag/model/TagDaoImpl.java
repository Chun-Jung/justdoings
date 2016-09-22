package com.justdoings.tag.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("tagDao")
@Transactional(propagation = Propagation.MANDATORY)
public class TagDaoImpl implements TagDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(Tag tag) {
		entityManager.persist(tag);
	}

	@Override
	public List<Tag> findBy(Integer actSeq) {
		Query query = entityManager.createNamedQuery("Tag.findByActSeq");
		query.setParameter("actSeq", actSeq);
		List<Tag> tags = query.getResultList();
		return tags;
	}

	@Override
	public void update(Tag tag) {
		entityManager.merge(tag);
	}

	@Override
	public void delete(Tag tag) {
		if(entityManager.contains(tag)){
			entityManager.remove(tag);
		}else{
			tag = entityManager.getReference(Tag.class, tag.getTagSeq());
			entityManager.remove(tag);
		}
	}

	@Override
	public int deleteBy(Integer actSeq) {
		Query query = entityManager.createNamedQuery("Tag.deleteByActSeq");
		query.setParameter("actSeq", actSeq);
		int count = (int) query.getSingleResult();
		return count;
	}

}
