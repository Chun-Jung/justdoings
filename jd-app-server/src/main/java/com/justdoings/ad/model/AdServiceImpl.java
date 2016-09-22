package com.justdoings.ad.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoings.act.model.Act;

@Service("adService")
public class AdServiceImpl implements AdService {
	
	@Autowired
	private AdDao adDao;

	@Override
	@Transactional
	public void insert(Ad ad) {
		adDao.insert(ad);
	}

	@Override
	@Transactional(readOnly = true)
	public Ad findBy(Integer adSeq) {
		return adDao.findBy(adSeq);
	}

	@Override
	@Transactional
	public void update(Ad ad) {
		adDao.update(ad);
	}

	@Override
	@Transactional
	public void delete(Ad ad) {
		adDao.delete(ad);
	}

	@Override
	@Transactional
	public void delete(Integer adSeq) {
		Ad ad = new Ad();
		ad.setAdSeq(adSeq);
		this.delete(ad);
	}

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		AdService service = (AdService) context.getBean("adService");
		
		Ad ad = new Ad();
		Act act = new Act();
		act.setActSeq(1);
		ad.setAct(act);
		service.insert(ad);
		
		Ad ad2 = service.findBy(ad.getAdSeq());
		ad2.setUrl("https://www.yahoo.com.tw");
		service.update(ad2);
		
		service.delete(ad2.getAdSeq());
	}
}
