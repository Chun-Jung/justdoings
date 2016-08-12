package com.justdoings.member.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.justdoings.status.code.model.StatusCode;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/** 會員編號 */
	private Integer memSeq;
	
	/** 電子信箱(帳號) */
	private String email;
	
	/** 密碼 */
	private String password;
	
	/** 姓名 */
	private String name;
	
	/** 性別 */
	private Integer sex;
	
	/** 手機 */
	private String mobilePhone;
	
	/** 影像檔案名稱 */
	private String imgFileName;
	
	/** 個人簡介 */
	private String content;
	
	/** 狀態 */
	@ManyToOne
	@JoinColumn(name="code", referencedColumnName="status")
	private StatusCode statusCode;
	
	/** UUID(忘記密碼) */
	private String uuid;
	
	/** UUID有效期限 */
	private Date uuidDt;
	
	/** 生日 */
	private Date birthday;
	
	/** 建立時間 */
	private Date createDt;

	/** 停權起日 */
	private Date disableBeginDt;
	
	/** 停權迄日 */
	private Date disableEndDt;
	
	/** 停權說明 */
	private String disableDesc;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
}
