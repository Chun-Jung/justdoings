package com.justdoings.act.msg.model;

import java.util.List;

public interface ActMsgService {
	/**
	 * 新增活動留言
	 * @param actMsg 活動留言
	 */
	void save(ActMsg actMsg);
	
	/**
	 * 新增活動留言
	 * @param actSeq 活動編號
	 * @param message 留言訊息
	 */
	void save(Integer actSeq, String message);
	
	/**
	 * 刪除活動留言
	 * @param actMsgSeq 活動留言編號
	 */
	void delete(Integer actMsgSeq);
	
	/**
	 * 搜尋該活動所有的留言
	 * @param actSeq 活動編號
	 * @return List<ActMsg>
	 */
	List<ActMsg> findByActSeq(Integer actSeq);
}
