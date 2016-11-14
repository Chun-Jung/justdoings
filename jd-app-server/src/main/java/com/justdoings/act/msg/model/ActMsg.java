package com.justdoings.act.msg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ActMsg {
	/** 留言編號 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "act_msg_seq")
	private Integer actMsgSeq;
	
	/** 活動編號 */
	@Column(name = "act_seq")
	private Integer actSeq;
	
	/** 訊息 */
	private String message;
	
	/** ============== getters and setters ============== */
	
	public Integer getActMsgSeq() {
		return actMsgSeq;
	}
	public void setActMsgSeq(Integer actMsgSeq) {
		this.actMsgSeq = actMsgSeq;
	}
	public Integer getActSeq() {
		return actSeq;
	}
	public void setActSeq(Integer actSeq) {
		this.actSeq = actSeq;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
