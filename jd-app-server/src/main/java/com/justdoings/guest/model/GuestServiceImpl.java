package com.justdoings.guest.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("guestService")
public class GuestServiceImpl implements GuestService {
	@Autowired
	private GuestDao guestDao;

	@Override
	@Transactional
	public void saveOrUpdate(Guest guest) {
		guestDao.save(guest);
		//TODO:影像上傳
	}

	@Override
	@Transactional
	public void delete(Guest guest) {
		guestDao.delete(guest);
	}

	@Override
	@Transactional
	public void delete(Integer guestSeq) {
		guestDao.delete(guestSeq);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Guest> findByActSeq(Integer actSeq) {
		return guestDao.findByActSeq(actSeq);
	}
}
