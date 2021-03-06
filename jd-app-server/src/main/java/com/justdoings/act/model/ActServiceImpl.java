package com.justdoings.act.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoings.act.location.model.Location;
import com.justdoings.constant.model.PageableConstant;
import com.justdoings.file.storage.model.FileStorageService;
import com.justdoings.member.model.Member;
import com.justdoings.member.model.MemberService;
import com.justdoings.organizer.model.Organizer;
import com.justdoings.organizer.model.OrganizerService;
import com.justdoings.status.code.model.StatusCode;
import com.justdoings.status.code.model.StatusCodeService;
import com.justdoings.status.code.model.StatusEnum;
import com.justdoings.utils.DateUtils;

@Service("actService")
public class ActServiceImpl implements ActService {
	
	@Autowired
	private ActDao actDao;
	
	@Autowired
	private StatusCodeService statusCodeService;
	
	@Autowired
	private FileStorageService fileStorageService;

	@Override
	@Transactional
	public void saveOrUpdate(Act act) {
		if(act.getActSeq()!= null && actDao.exists(act.getActSeq())){
			// 新增
			saveNewAct(act);
		}else{
			// 修改
			updateAct(act);
		}
	}
	
	private void saveNewAct(Act act){
		
	}
	
	private void updateAct(Act act){
		
	}
	
	private String saveFile(String posterName){
		return null;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Act findOne(Integer actSeq) {
		Act act = actDao.findOne(actSeq);
		StatusCode memberStatus = statusCodeService.findOne(StatusEnum.Act, act.getStatus());
		act.setStatusCode(memberStatus);
		return act;
	}

	@Override
	@Transactional
	public void delete(Integer actSeq) {
		actDao.delete(actSeq);
	}

	@Override
	@Transactional
	public void delete(Act act) {
		delete(act.getActSeq());
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByShortLink(String shortLink) {
		return actDao.countByShortLink(shortLink);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Act> findByisRecomm() {
		Pageable instructions = new PageRequest(PageableConstant.INIT_PAGE_SIZE, PageableConstant.RECOMMEND_ACT_PAGE_SIZE);
		return actDao.findByisRecomm(1, instructions).getContent();
	}
	
//	@Override
//	@Transactional(readOnly = true)
//	public Integer countTrackingNumber(Integer actSeq) {
//		return actDao.countTrackingNumber(actSeq);
//	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		MemberService memService = (MemberService) context.getBean("memberService");
		OrganizerService orgService = (OrganizerService) context.getBean("organizerService");
		ActService actService = (ActService) context.getBean("actService");
		
		Member member = new Member();
		member.setBirthday(new Date());
		member.setCreateDt(new Date());
		member.setEmail("test@justdoings.com");
		member.setMobilePhone("+886 910-123-456");
		member.setName("test");
		member.setPassword("test");
		member.setSex(1);
		memService.saveOrUpdate(member);
		Organizer org = new Organizer();
		org.setMember(member);
		org.setName("讀書會");
		org.setEmail(member.getEmail());
		org.setStatus(100);
		orgService.saveOrUpdate(org);
		
		Act act = new Act();
		act.setOrganizer(org);
		act.setAddr("台北市松山文創園區");
		act.setAddrLat(25.0440948);
		act.setAddrLon(121.5565273);
		Location loc = new Location();
		loc.setLocSeq(2);
		act.setLocation(loc);
		act.setTitle("Justdoings發表會");
		act.setProfile("Justdoings簡介");
		act.setRefundsWay(1);
		act.setBeginDt(DateUtils.getDate(2016, 9, 9, 0, 0, 0));
		act.setEndDt(DateUtils.getDate(2037, 12, 31, 21, 0, 0));
		act.setIsPubAct(1);
		act.setIsPubInfo(1);
		act.setStatus(200);
		actService.saveOrUpdate(act);
		
		Act act2 = actService.findOne(act.getActSeq());
		act2.setStatus(300);
		act2.setEndDt(DateUtils.getDate(2017, 02, 01, 21, 30, 0));
		act2.getLocation().setLocSeq(3);
		actService.saveOrUpdate(act2);
		
		member = memService.findOne(member.getMemSeq());
		List<Act> collecting = new ArrayList<>();
		collecting.add(act2);
		member.setCollecting(collecting);
		memService.saveOrUpdate(member);
		
		System.out.println("shortLink count: " + actService.countByShortLink("justdoings-present"));
		
		actService.delete(act2);
		orgService.delete(org);
		memService.delete(member);
	}
}
