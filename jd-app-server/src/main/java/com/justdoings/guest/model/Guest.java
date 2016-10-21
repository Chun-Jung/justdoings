package com.justdoings.guest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Guest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "guest_seq")
	/** 活動嘉賓編號 */
	private Integer guestSeq;
	
	@Column(name = "act_seq")
	/** 活動編號 */
	private Integer actSeq;
	
	@Column(name = "img_file_name")
	/** 影像檔案名稱 */
	private String imgFileName;
	
	/** 嘉賓連結 */
	private String link;
	
	/** 簡介 */
	private String profile;
	
	/** 姓名 */
	private String name;
	
	@Column(name = "create_dt")
	/** 建立時間 */
	private Date createDt;
	
	/** ============== other domain fields ============== */
	
	/** 影像檔案 */
	private byte[] imgFile;
	
	/** ============== getters and setters ============== */

	public Integer getGuestSeq() {
		return guestSeq;
	}

	public void setGuestSeq(Integer guestSeq) {
		this.guestSeq = guestSeq;
	}

	public Integer getActSeq() {
		return actSeq;
	}

	public void setActSeq(Integer actSeq) {
		this.actSeq = actSeq;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public byte[] getImgFile() {
		return imgFile;
	}

	public void setImgFile(byte[] imgFile) {
		this.imgFile = imgFile;
	}
}
