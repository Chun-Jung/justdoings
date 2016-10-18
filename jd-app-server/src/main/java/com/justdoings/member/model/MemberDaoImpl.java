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
	public void saveOrUpdate(Member member) {
		if(member.getMemSeq() == null){
			entityManager.persist(member);
		} else if(!entityManager.contains(member)){
			entityManager.merge(member);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Member findOneBy(String email) {
		TypedQuery<Member> tq = entityManager.createQuery("FROM Member WHERE email=?", Member.class);
		tq.setParameter(1, email);
		return tq.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public Member findOne(Integer memSeq) {
		return entityManager.find(Member.class, memSeq);
	}

	@Override
	@Transactional
	public void delete(Integer memSeq) {
		Member member = findOne(memSeq);
		if(member != null){
			entityManager.remove(member);
		}
	}

}
