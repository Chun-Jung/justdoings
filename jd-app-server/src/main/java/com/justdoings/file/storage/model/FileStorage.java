package com.justdoings.file.storage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "file_storage")
public class FileStorage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_seq")
	private Integer fileSeq;
	
	private String path;
	
	private String name;
	
	@Column(name = "create_dt")
	private Date createDt;
	
	/** ============== getters and setters ============== */

	public Integer getFileSeq() {
		return fileSeq;
	}

	public void setFileSeq(Integer fileSeq) {
		this.fileSeq = fileSeq;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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
}
