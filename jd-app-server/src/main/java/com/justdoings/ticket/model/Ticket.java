package com.justdoings.ticket.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.justdoings.status.code.model.StatusCode;
import com.justdoings.ticket.info.model.TicketInfo;
import com.justdoings.ticket.order.model.TicketOrder;

@Entity
@Table
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tic_seq")
	/** 票卷編號 */
	private Integer ticSeq;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ord_seq")
	/** 訂單 */
	private TicketOrder ticOrd;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tic_info_seq")
	/** 票卷資訊 */
	private TicketInfo ticInfo;

	@Column(name = "owner_name")
	/** 持有者名稱 */
	private String ownerName;
	
	@Column(name = "create_dt")
	/** 建立時間 */
	private Date createDt;
	
	/** 票卷狀態碼 */
	private Integer status;
	
	/** ============== other domain fields ============== */
	
	/** 票卷狀態封裝物件 */
	@Transient
	private StatusCode statusCode;

	/** ============== getters and setters ============== */
	
	public Integer getTicSeq() {
		return ticSeq;
	}

	public void setTicSeq(Integer ticSeq) {
		this.ticSeq = ticSeq;
	}

	public TicketOrder getTicOrd() {
		return ticOrd;
	}

	public void setTicOrd(TicketOrder ticOrd) {
		this.ticOrd = ticOrd;
	}

	public TicketInfo getTicInfo() {
		return ticInfo;
	}

	public void setTicInfo(TicketInfo ticInfo) {
		this.ticInfo = ticInfo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}
}
