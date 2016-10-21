package com.justdoings.ticket.order.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.justdoings.status.code.model.StatusCode;

@Entity
@Table(name = "ticket_order")
public class TicketOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ord_seq")
	/** 訂單編號 */
	private Integer ordSeq;
	
	@Column(name = "mem_seq")
	/** 會員編號 */
	private Integer memSeq;
	
	@Column(name = "act_Seq")
	/** 活動編號 */
	private Integer actSeq;
	
	/** 訂單狀態 */
	private Integer status;
	
	@Column(name = "create_Dt", insertable = false, updatable = false)
	/** 訂單建立時間 */
	private Date createDt;
	
	@Column(name = "finish_dt")
	/** 訂單完成時間 */
	private Date finishDt;
	
	@Column(name = "paid_before_dt")
	/** 訂單付款期限 */
	private Date paidBeforeDt;
	
	@Column(name = "refund_apply_dt")
	/** 退票申請時間 */
	private Date refundApplyDt;
	
	@Column(name = "refund_finish_dt")
	/** 退票完成時間 */
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

	public Integer getActSeq() {
		return actSeq;
	}

	public void setActSeq(Integer actSeq) {
		this.actSeq = actSeq;
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
