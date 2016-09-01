package com.justdoings.member.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("memberDao")
@Transactional(propagation = Propagation.MANDATORY)
public class MemberDaoImpl implements MemberDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	public void insert(Member member) {
		entityManager.persist(member);
	}

	@Override
	@Transactional(readOnly = true)
	public Member findBy(String email) {
		return entityManager.find(Member.class, email);
	}

	@Override
	@Transactional(readOnly = true)
	public Member findBy(Integer memSeq) {
		return entityManager.find(Member.class, memSeq);
	}

	@Override
	@Transactional
	public void update(Member member) {
		entityManager.persist(member);
	}

	@Override
	@Transactional
	public void delete(Member member) {
		if(entityManager.contains(member)){
			entityManager.remove(member);
		}else{
			member = entityManager.getReference(Member.class, member.getMemSeq());
			entityManager.remove(member);
		}
	}

}
