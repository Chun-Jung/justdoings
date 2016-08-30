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
	public void insert(Member member) {
		entityManager.persist(member);
	}

	@Override
	public Member findBy(String email) {
		return entityManager.find(Member.class, email);
	}

	@Override
	public Member findBy(Integer memSeq) {
		return entityManager.find(Member.class, memSeq);
	}

	@Override
	public void update(Member member) {
		entityManager.persist(member);
	}

	@Override
	public void delete(Member member) {
		entityManager.remove(member);
	}

}
