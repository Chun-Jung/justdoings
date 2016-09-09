package com.justdoings.member.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.FetchType;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoings.organizer.model.Organizer;
import com.justdoings.status.code.model.StatusCode;
import com.justdoings.status.code.model.StatusCodeService;
import com.justdoings.status.code.model.StatusEnum;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired 
	private MemberDao memberDao;
	
	@Autowired 
	private StatusCodeService statusCodeService;

	@Override
	@Transactional
	public void insert(Member member) {
		memberDao.insert(member);
	}

	@Override
	@Transactional(readOnly = true)
	public Member findBy(String email) {
		Member result = memberDao.findBy(email);
		StatusCode memberStatus = statusCodeService.findBy(StatusEnum.Member, result.getStatus());
		result.setStatusCode(memberStatus);
		result.getOrganizerTracking().size(); // lazy -> eager
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Member findBy(Integer memSeq) {
		Member result = memberDao.findBy(memSeq);
		StatusCode memberStatus = statusCodeService.findBy(StatusEnum.Member, result.getStatus());
		result.setStatusCode(memberStatus);
		result.getOrganizerTracking().size(); // lazy -> eager
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
		MemberService service = (MemberService) context.getBean("memberService");
		
		Member member = new Member();
		member.setBirthday(new Date());
		member.setCreateDt(new Date());
		member.setEmail("test@justdoings.com");
		member.setMobilePhone("+886 910-123-456");
		member.setName("test");
		member.setPassword("test");
		member.setSex(1);
		service.insert(member);

		Member member2 = service.findBy("test@justdoings.com");
		System.out.println(member2);

		member2.setSex(2);
		member2.setName("TEST");
		member2.setPassword("TEST");
		member2.setStatus(300);
		service.update(member2);

		service.delete(member2);
		
		Member testMember = service.findBy(2);
		for(Organizer org : testMember.getOrganizerTracking()){
			System.out.println(org.getName());
		}
	}
}
