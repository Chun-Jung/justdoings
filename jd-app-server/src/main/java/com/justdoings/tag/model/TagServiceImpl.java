package com.justdoings.tag.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoings.act.model.Act;

@Service("tagService")
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagDao tagDao;

	@Override
	@Transactional
	public void save(Tag tag) {
		tagDao.save(tag);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tag> findBy(Integer actSeq) {
		return tagDao.findByActSeq(actSeq);
	}

	@Override
	@Transactional
	public void update(Tag tag) {
		tagDao.save(tag);
	}

	@Override
	@Transactional
	public void delete(Tag tag) {
		tagDao.delete(tag);
	}

	@Override
	@Transactional
	public int deleteBy(Integer actSeq) {
		return tagDao.deleteByActSeq(actSeq);
	}
	
	@Override
	@Transactional
	public void saveBy(Integer actSeq, String... tags) {
		for(String tagName : tags){
			Tag tag = new Tag();
			tag.setActSeq(actSeq);
			tag.setName(tagName);
			this.save(tag);
		}
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		TagService service = (TagService) context.getBean("tagService");
		
		service.saveBy(1, "Justdoings", "說明會", "活動平台");
	}
}
