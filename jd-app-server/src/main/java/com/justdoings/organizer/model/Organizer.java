package com.justdoings.organizer.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.justdoings.member.model.Member;
import com.justdoings.status.code.model.StatusCode;

@Entity
public class Organizer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/** �D����s�� */
	private Integer orgSeq;
	
	@ManyToOne
	@JoinColumn(name="memSeq")
	/** �|�� */
	private Member member;
	
	/** �W�� */
	private String name;
	
	/** �a�} */
	private String addr;
	
	/** �q�� */
	private String telNo;
	
	/** �ǯu */
	private String faxNo;
	
	/** �q�l�H�c */
	private String email;
	
	/** �x��s�� */
	private String link;
	
	/** �u���} */
	private String shortLink;
	
	/** �D���줶�� */
	private String content;
	
	/** �v���ɮצW�� */
	private String imgFileName;
	
	@ManyToOne
	@JoinColumn(name="code", referencedColumnName="status")	
	/** ���A�X */
	private StatusCode statusCode;
	
	@ManyToMany(mappedBy="organizerTracking")
	/** �֦b�l�� */
	private List<Member> trackers;
	
	/** �إߤ�� */
	private Date createDt;
	
	/** ��s��� */
	private Date updateDt;

	public Integer getOrgSeq() {
		return orgSeq;
	}

	public void setOrgSeq(Integer orgSeq) {
		this.orgSeq = orgSeq;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getShortLink() {
		return shortLink;
	}

	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public List<Member> getTrackers() {
		return trackers;
	}

	public void setTrackers(List<Member> trackers) {
		this.trackers = trackers;
	}
}
