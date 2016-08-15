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
	/** 主辦單位編號 */
	private Integer orgSeq;
	
	@ManyToOne
	@JoinColumn(name="memSeq")
	/** 會員 */
	private Member member;
	
	/** 名稱 */
	private String name;
	
	/** 地址 */
	private String addr;
	
	/** 電話 */
	private String telNo;
	
	/** 傳真 */
	private String faxNo;
	
	/** 電子信箱 */
	private String email;
	
	/** 官方連結 */
	private String link;
	
	/** 短網址 */
	private String shortLink;
	
	/** 主辦單位介紹 */
	private String content;
	
	/** 影像檔案名稱 */
	private String imgFileName;
	
	@ManyToOne
	@JoinColumn(name="code", referencedColumnName="status")	
	/** 狀態碼 */
	private StatusCode statusCode;
	
	@ManyToMany(mappedBy="organizerTracking")
	/** 誰在追蹤 */
	private List<Member> trackers;
	
	/** 建立日期 */
	private Date createDt;
	
	/** 更新日期 */
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
