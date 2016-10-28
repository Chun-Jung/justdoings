package com.justdoings.ticket.order.model;

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
@Table(name = "ticket_order")
public class TicketOrder {
	/** 訂單編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ord_seq")
	private Integer ordSeq;
	
	/** 會員編號 */
	@Column(name = "mem_seq")
	private Integer memSeq;
	
	/** 活動 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "act_seq")
	private Act act;
	
	/** 訂單狀態 */
	private Integer status;
	
	/** 訂單建立時間 */
	@Column(name = "create_Dt", insertable = false, updatable = false)
	private Date createDt;
	
	/** 訂單完成時間 */
	@Column(name = "finish_dt")
	private Date finishDt;
	
	/** 訂單付款期限 */
	@Column(name = "paid_before_dt")
	private Date paidBeforeDt;
	
	/** 退票申請時間 */
	@Column(name = "refund_apply_dt")
	private Date refundApplyDt;
	
	/** 退票完成時間 */
	@Column(name = "refund_finish_dt")
	private Date refundFinishDt;
	
	/** ============== other domain fields ============== */
	
	/** 訂單狀態封裝物件 */
	@Transient
	private StatusCode statusCode;
	
	/** ============== getters and setters ============== */

	public Integer getOrdSeq() {
		return ordSeq;
	}

	public void setOrdSeq(Integer ordSeq) {
		this.ordSeq = ordSeq;
	}

	public Integer getMemSeq() {
		return memSeq;
	}

	public void setMemSeq(Integer memSeq) {
		this.memSeq = memSeq;
	}

	public Act getAct() {
		return act;
	}

	public void setAct(Act act) {
		this.act = act;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getFinishDt() {
		return finishDt;
	}

	public void setFinishDt(Date finishDt) {
		this.finishDt = finishDt;
	}

	public Date getPaidBeforeDt() {
		return paidBeforeDt;
	}

	public void setPaidBeforeDt(Date paidBeforeDt) {
		this.paidBeforeDt = paidBeforeDt;
	}

	public Date getRefundApplyDt() {
		return refundApplyDt;
	}

	public void setRefundApplyDt(Date refundApplyDt) {
		this.refundApplyDt = refundApplyDt;
	}

	public Date getRefundFinishDt() {
		return refundFinishDt;
	}

	public void setRefundFinishDt(Date refundFinishDt) {
		this.refundFinishDt = refundFinishDt;
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

}
