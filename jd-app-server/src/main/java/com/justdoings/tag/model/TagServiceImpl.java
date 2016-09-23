package com.justdoings.tag.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.justdoings.act.model.Act;

@Service("tagService")
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagDao tagDao;

	@Override
	@Transactional
	public void insert(Tag tag) {
		tagDao.insert(tag);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tag> findBy(Integer actSeq) {
		List<Tag> result = tagDao.findBy(actSeq);
		return result;
	}

	@Override
	@Transactional
	public void update(Tag tag) {
		tagDao.update(tag);
	}

	@Override
	@Transactional
	public void delete(Tag tag) {
		tagDao.delete(tag);
	}

	@Override
	@Transactional
	public int deleteBy(Integer actSeq) {
		return tagDao.deleteBy(actSeq);
	}
	
	@Override
	@Transactional
	public void insertBy(Integer actSeq, String... tags) {
		Act act = new Act();
		act.setActSeq(actSeq);
		
		for(String tagName : tags){
			Tag tag = new Tag();
			tag.setAct(act);
			tag.setName(tagName);
			this.insert(tag);
		}
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		TagService service = (TagService) context.getBean("tagService");
		
		service.insertBy(1, "Justdoings", "說明會", "活動平台");
	}
}
