package com.justdoings.member.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.justdoings.organizer.model.Organizer;
import com.justdoings.status.code.model.StatusCode;

@Entity
@Table
public class Member {
	/** 會員編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mem_seq")
	private Integer memSeq;

	/** 信箱(帳號) */
	private String email;

	/** 密碼 */
	private String password;

	/** 姓名 */
	private String name;

	/** 性別 */
	private Integer sex;

	/** 手機號碼 */
	@Column(name = "mobile_phone")
	private String mobilePhone;

	/** 影像檔案名稱 */
	@Column(name = "img_file_name")
	private String imgFileName;

	/** 簡介 */
	private String profile;

	/** 狀態碼 */
	@Column(insertable = false)
 	private Integer status;

	/** UUID(忘記密碼) */
	private String uuid;

	/** UUID有效期限 */
	@Column(name = "uuid_dt")
	private Date uuidDt;

	/** 生日 */
	private Date birthday;

	/** 建立時間 */
	@Column(name = "create_dt", insertable = false, updatable = false)
	private Date createDt;

	/** 停權起日 */
	@Column(name = "disable_begin_dt")
	private Date disableBeginDt;

	/** 停權迄日 */
	@Column(name = "disable_end_dt")
	private Date disableEndDt;

	/** 停權描述 */
	@Column(name = "disable_desc")
	private String disableDesc;

	/** 追蹤的主辦單位 */
	@ManyToMany
	@JoinTable(name = "organizer_tracking", joinColumns = @JoinColumn(name = "mem_seq") , inverseJoinColumns = @JoinColumn(name = "org_seq") )
	private List<Organizer> organizerTracking;
	
	/** 狀態碼封裝物件 */
	@Transient
	private StatusCode statusCode;

	public Integer getMemSeq() {
		return memSeq;
	}

	public void setMemSeq(Integer memSeq) {
		this.memSeq = memSeq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getUuidDt() {
		return uuidDt;
	}

	public void setUuidDt(Date uuidDt) {
		this.uuidDt = uuidDt;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getDisableBeginDt() {
		return disableBeginDt;
	}

	public void setDisableBeginDt(Date disableBeginDt) {
		this.disableBeginDt = disableBeginDt;
	}

	public Date getDisableEndDt() {
		return disableEndDt;
	}

	public void setDisableEndDt(Date disableEndDt) {
		this.disableEndDt = disableEndDt;
	}

	public String getDisableDesc() {
		return disableDesc;
	}

	public void setDisableDesc(String disableDesc) {
		this.disableDesc = disableDesc;
	}

	public List<Organizer> getOrganizerTracking() {
		return organizerTracking;
	}

	public void setOrganizerTracking(List<Organizer> organizerTracking) {
		this.organizerTracking = organizerTracking;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
