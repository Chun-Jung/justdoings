package com.justdoings.ad.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoings.act.model.Act;
import com.justdoings.act.model.ActService;
import com.justdoings.utils.DateUtils;

@Service("adService")
public class AdServiceImpl implements AdService {

	@Autowired
	private AdDao adDao;
	
	@Autowired
	private ActService actService;

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
		delete(ad.getAdSeq());
	}

	@Override
	@Transactional
	public void delete(Integer adSeq) {
		adDao.delete(adSeq);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ad> findEffectAd() {
		List<Ad> ads = adDao.findEffectAd(new Date());
//		ads.forEach(ad -> ad.getAct().setTrackingNumber(actService.countTrackingNumber(ad.getAct().getActSeq())));
		return ads;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Act> findEffectAct() {
		List<Act> acts = adDao.findEffectAdAct(new Date());
//		acts.forEach(act -> act.setTrackingNumber(actService.countTrackingNumber(act.getActSeq())));
		return acts;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		AdService service = (AdService) context.getBean("adService");

		Ad ad = new Ad();
		Act act = new Act();
		act.setActSeq(1);
		ad.setAct(act);
		ad.setEffectBeginDt(DateUtils.getDate(2016, 11, 2, 0, 0, 0));
		ad.setEffectEndDt(DateUtils.getDate(2017, 12, 31, 23, 59, 59));
		service.saveOrUpdate(ad);

		Ad ad2 = service.findOne(ad.getAdSeq());
		ad2.setEffectEndDt(DateUtils.getDate(2099, 12, 31, 23, 59, 59));
		service.saveOrUpdate(ad2);

		service.delete(ad2);
	}
}
