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
	public void saveOrUpdate(Ad ad) {
		adDao.save(ad);
	}

	@Override
	@Transactional(readOnly = true)
	public Ad findOne(Integer adSeq) {
		return adDao.findOne(adSeq);
	}

	@Override
	@Transactional
	public void delete(Ad ad) {
		adDao.delete(ad.getAdSeq());
	}

	@Override
	@Transactional
	public void delete(Integer adSeq) {
		adDao.delete(adSeq);
	}

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		AdService service = (AdService) context.getBean("adService");
		
		Ad ad = new Ad();
		Act act = new Act();
		act.setActSeq(1);
		ad.setAct(act);
		service.saveOrUpdate(ad);
		
		Ad ad2 = service.findOne(ad.getAdSeq());
		ad2.setUrl("https://www.yahoo.com.tw");
		service.saveOrUpdate(ad2);
		
		service.delete(ad2.getAdSeq());
	}
}
