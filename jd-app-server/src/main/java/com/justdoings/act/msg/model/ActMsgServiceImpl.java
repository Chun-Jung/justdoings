package com.justdoings.act.msg.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("actMsgService")
public class ActMsgServiceImpl implements ActMsgService {
	@Autowired
	private ActMsgDao actMsgDao;

	@Override
	@Transactional
	public void save(ActMsg actMsg) {
		actMsgDao.save(actMsg);
	}

	@Override
	@Transactional
	public void save(Integer actSeq, String message) {
		ActMsg actMsg = new ActMsg();
		actMsg.setActSeq(actSeq);
		actMsg.setMessage(message);
		save(actMsg);
	}

	@Override
	@Transactional
	public void delete(Integer actMsgSeq) {
		actMsgDao.delete(actMsgSeq);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ActMsg> findByActSeq(Integer actSeq) {
		return actMsgDao.findByActSeq(actSeq);
	}

}
