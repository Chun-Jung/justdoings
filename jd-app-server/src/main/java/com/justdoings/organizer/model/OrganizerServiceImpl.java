package com.justdoings.organizer.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoings.member.model.Member;
import com.justdoings.member.model.MemberService;
import com.justdoings.status.code.model.StatusCode;
import com.justdoings.status.code.model.StatusCodeService;
import com.justdoings.status.code.model.StatusEnum;

@Service("organizerService")
public class OrganizerServiceImpl implements OrganizerService {
	
	@Autowired
	private OrganizerDao organizerDao;
	
	@Autowired
	private StatusCodeService statusCodeService;

	@Override
	@Transactional
	public void saveOrUpdate(Organizer org) {
		organizerDao.save(org);
	}

	@Override
	@Transactional(readOnly = true)
	public Organizer findOne(Integer orgSeq) {
		Organizer org = organizerDao.findOne(orgSeq);
		StatusCode statusCode = statusCodeService.findOne(StatusEnum.Orginizer, org.getStatus());
		org.setStatusCode(statusCode); // not lazy catch
		return org;
	}

	@Override
	@Transactional
	public void delete(Integer orgSeq) {
		organizerDao.delete(orgSeq);
	}

	@Override
	@Transactional
	public void delete(Organizer org) {
		delete(org.getOrgSeq());
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		
		OrganizerService orgService = (OrganizerService) context.getBean("organizerService");
		MemberService memService = (MemberService) context.getBean("memberService");
		
		Member member = new Member();
		member.setBirthday(new Date());
		member.setEmail("test@justdoings.com");
		member.setMobilePhone("+886 910-123-456");
		member.setName("test");
		member.setPassword("test");
		member.setSex(1);
		memService.saveOrUpdate(member);

		System.out.println("1. insert");
		Organizer org = new Organizer();
		org.setMember(member);
		org.setName("讀書會");
		org.setEmail(member.getEmail());
		org.setStatus(100);
		orgService.saveOrUpdate(org);
		System.out.println("memSeq: " + org.getOrgSeq() + "\n");
		
		System.out.println("2. update");
		org.setStatus(200);
		orgService.saveOrUpdate(org);
		System.out.println("status: " + org.getStatus() + "\n");
		
		System.out.println("3. delete");
		orgService.delete(org.getOrgSeq());
		memService.delete(member);
		
		System.out.println("\n\nFinish");
		
	}

}
