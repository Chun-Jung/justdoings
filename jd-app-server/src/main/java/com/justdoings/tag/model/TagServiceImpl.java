package com.justdoings.tag.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tagService")
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagDao tagDao;

	@Override
	public void insert(Tag tag) {
		tagDao.insert(tag);
	}

	@Override
	public List<Tag> findBy(Integer actSeq) {
		return null;
	}

	@Override
	public void update(Tag tag) {

	}

	@Override
	public void delete(Tag tag) {

	}

	@Override
	public int deleteBy(Integer actSeq) {
		return 0;
	}

}
