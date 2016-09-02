package com.justdoings.member.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoings.status.code.model.StatusCodeDao;
import com.justdoings.status.code.model.StatusCodeId;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberDao memberDao;
	
	@Autowired StatusCodeDao statusCodeDao;

	@Override
	@Transactional
	public void insert(Member member) {
		memberDao.insert(member);
	}

	@Override
	@Transactional(readOnly = true)
	public Member findBy(String email) {
		Member result = memberDao.findBy(email);
		StatusCodeId primaryKey = new StatusCodeId();
		primaryKey.setStatusSeq(3);
		primaryKey.setCode(result.getStatus());
		result.setStatusCode(statusCodeDao.findBy(primaryKey));
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Member findBy(Integer memSeq) {
		Member result = memberDao.findBy(memSeq);
		StatusCodeId primaryKey = new StatusCodeId();
		primaryKey.setStatusSeq(3);
		primaryKey.setCode(result.getStatus());
		result.setStatusCode(statusCodeDao.findBy(primaryKey));
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
		
//		Member member = new Member();
//		member.setBirthday(new Date());
//		member.setCreateDt(new Date());
//		member.setEmail("test@justdoings.com");
//		member.setMobilePhone("+886 910-123-456");
//		member.setName("test");
//		member.setPassword("test");
//		member.setSex(1);
//		StatusCode statusCode = new StatusCode();
//		statusCode.setStatusSeq(3);
//		statusCode.setCode(200);
//		member.setStatusCode(statusCode);
//		service.insert(member);
		
		Member member2 = service.findBy("test@justdoings.com");
		System.out.println(member2);
	}
}
