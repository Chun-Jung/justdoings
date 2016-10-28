package com.justdoings.ticket.info.model;

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

import com.justdoings.act.model.Act;
import com.justdoings.status.code.model.StatusCode;

@Entity
@Table(name = "ticket_info")
public class TicketInfo {
	/** 票卷資訊編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tic_info_seq")
	private Integer ticInfoSeq;
	
	/** 活動 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "act_seq")
	private Act act;
	
	/** 票卷名稱 */
	@Column(name = "tic_name")
	private String ticName;
	
	/** 票卷組別名稱 */
	@Column(name = "group_name")
	private String groupName;
	
	/** 票卷說明 */
	@Column(name = "tic_explain")
	private String ticExplain;
	
	/** 票價 */
	private Integer price;
	
	/** 票卷總數 */
	@Column(name = "tic_total_no")
	private Integer ticTotalNo;
	
	/** 已付款數量 */
	@Column(name = "tic_paid_no")
	private Integer ticPaidNo;
	
	/** 尚未付款數量 */
	@Column(name = "tic_unpaid_no")
	private Integer ticUnpaidNo;
	
	/** 最少購買數量 */
	@Column(name = "buy_min_no")
	private Integer buyMinNo;
	
	/** 最多購買數量 */
	@Column(name = "buy_max_no")
	private Integer buyMaxNo;
	
	/** 票卷資訊狀態碼 */
	private Integer status;
	
	/** 票卷開始售票日 */
	@Column(name = "tic_sell_begin_dt")
	private Date ticSellBeginDt;
	
	/** 票卷停售日 */
	@Column(name = "tic_sell_end_dt")
	private Date ticSellEndDt;
	
	/** 票卷有效起日 */
	@Column(name = "tic_val_begin_dt")
	private Date ticValBeginDt;
	
	/** 票卷結束日 */
	@Column(name = "tic_val_end_dt")
	private Date ticValEndDt;
	
	/** ============== other domain fields ============== */
	
	/** 票卷資訊狀態封裝物件 */
	@Transient
	private StatusCode statusCode;
	
	/** ============== getters and setters ============== */

	public Integer getTicInfoSeq() {
		return ticInfoSeq;
	}

	public void setTicInfoSeq(Integer ticInfoSeq) {
		this.ticInfoSeq = ticInfoSeq;
	}

	public Act getAct() {
		return act;
	}

	public void setAct(Act act) {
		this.act = act;
	}

	public String getTicName() {
		return ticName;
	}

	public void setTicName(String ticName) {
		this.ticName = ticName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getTicExplain() {
		return ticExplain;
	}

	public void setTicExplain(String ticExplain) {
		this.ticExplain = ticExplain;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTicTotalNo() {
		return ticTotalNo;
	}

	public void setTicTotalNo(Integer ticTotalNo) {
		this.ticTotalNo = ticTotalNo;
	}

	public Integer getTicPaidNo() {
		return ticPaidNo;
	}

	public void setTicPaidNo(Integer ticPaidNo) {
		this.ticPaidNo = ticPaidNo;
	}

	public Integer getTicUnpaidNo() {
		return ticUnpaidNo;
	}

	public void setTicUnpaidNo(Integer ticUnpaidNo) {
		this.ticUnpaidNo = ticUnpaidNo;
	}

	public Integer getBuyMinNo() {
		return buyMinNo;
	}

	public void setBuyMinNo(Integer buyMinNo) {
		this.buyMinNo = buyMinNo;
	}

	public Integer getBuyMaxNo() {
		return buyMaxNo;
	}

	public void setBuyMaxNo(Integer buyMaxNo) {
		this.buyMaxNo = buyMaxNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getTicSellBeginDt() {
		return ticSellBeginDt;
	}

	public void setTicSellBeginDt(Date ticSellBeginDt) {
		this.ticSellBeginDt = ticSellBeginDt;
	}

	public Date getTicSellEndDt() {
		return ticSellEndDt;
	}

	public void setTicSellEndDt(Date ticSellEndDt) {
		this.ticSellEndDt = ticSellEndDt;
	}

	public Date getTicValBeginDt() {
		return ticValBeginDt;
	}

	public void setTicValBeginDt(Date ticValBeginDt) {
		this.ticValBeginDt = ticValBeginDt;
	}

	public Date getTicValEndDt() {
		return ticValEndDt;
	}

	public void setTicValEndDt(Date ticValEndDt) {
		this.ticValEndDt = ticValEndDt;
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}
}
