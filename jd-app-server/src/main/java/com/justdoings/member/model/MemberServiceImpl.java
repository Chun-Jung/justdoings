package com.justdoings.member.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberDao memberDao;

	@Override
	@Transactional
	public void insert(Member member) {
		memberDao.insert(member);
	}

	@Override
	@Transactional(readOnly = true)
	public Member findBy(String email) {
		Member result = memberDao.findBy(email);
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Member findBy(Integer memSeq) {
		Member result = memberDao.findBy(memSeq);
		return result;
	}

	@Override
	@Transactional
	public void update(Member member) {
		memberDao.update(member);
	}

	@Override
	@Transactional
	public void delete(Member member) {
		memberDao.delete(member);
	}

	@Override
	public void delete(Integer memSeq) {
		Member member = new Member();
		member.setMemSeq(memSeq);
		this.delete(member);
	}

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	}
}
