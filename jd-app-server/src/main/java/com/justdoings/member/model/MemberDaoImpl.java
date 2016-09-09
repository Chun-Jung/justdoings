package com.justdoings.member.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		TypedQuery<Member> tq = entityManager.createQuery("FROM Member WHERE email=?", Member.class);
		tq.setParameter(1, email);
		return tq.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public Member findBy(Integer memSeq) {
		return entityManager.find(Member.class, memSeq);
	}

	@Override
	@Transactional
	public void update(Member member) {
		entityManager.merge(member);
	}

	@Override
	@Transactional
	public void delete(Member member) {
		if (entityManager.contains(member)) {
			entityManager.remove(member);
		} else {
			member = entityManager.getReference(Member.class, member.getMemSeq());
			entityManager.remove(member);
		}
	}

}
