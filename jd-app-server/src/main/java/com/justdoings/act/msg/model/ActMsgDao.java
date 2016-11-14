package com.justdoings.act.msg.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface ActMsgDao extends CrudRepository<ActMsg, Integer> {
	/**
	 * 搜尋該活動所有的留言
	 * @param actSeq 活動編號
	 * @return List<ActMsg>
	 */
	List<ActMsg> findByActSeq(Integer actSeq);
}
