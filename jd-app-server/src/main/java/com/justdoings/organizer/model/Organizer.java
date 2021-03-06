package com.justdoings.organizer.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.justdoings.member.model.Member;
import com.justdoings.status.code.model.StatusCode;

@Entity
@Table
public class Organizer {
	/** 主辦單位編號 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "org_seq")
	private Integer orgSeq;
	
	/** 會員編號 */
	@ManyToOne
	@JoinColumn(name="mem_seq")
	private Member member;
	
	/** 主辦單位名稱 */
	private String name;
	
	/** 地址 */
	private String addr;
	
	/** 電話號碼 */
	@Column(name = "tel_no")
	private String telNo;
	
	/** 傳真號碼 */
	@Column(name = "fax_no")
	private String faxNo;
	
	/** 信箱 */
	private String email;
	
	/** 網站連結 */
	private String link;
	
	/** 短連結 */
	@Column(name = "short_link")
	private String shortLink;
	
	/** 簡介 */
	private String profile;
	
	/** 影像檔案名稱 */
	@Column(name = "img_file_name")
	private String imgFileName;
	
	/** 狀態碼 */
	private Integer status;
	
	/** 建立時間 */
	@Column(name = "create_dt", insertable = false, updatable = false)
	private Date createDt;
	
	/** 最後更新時間 */
	@Column(name = "update_dt")
	private Date updateDt;
	
	/** ============== other domain fields ============== */
	
	/** 狀態碼封裝物件 */
	@Transient
	private StatusCode statusCode;
	
	/** 影像檔案 */
	@Transient
	private byte[] imgFile;
	
	/** 追蹤的使用者 */
	@ManyToMany(mappedBy="organizerTracking")
	private List<Member> trackers;
	
	/** ============== getters and setters ============== */

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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
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

	public List<Member> getTrackers() {
		return trackers;
	}

	public void setTrackers(List<Member> trackers) {
		this.trackers = trackers;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public byte[] getImgFile() {
		return imgFile;
	}

	public void setImgFile(byte[] imgFile) {
		this.imgFile = imgFile;
	}

}
