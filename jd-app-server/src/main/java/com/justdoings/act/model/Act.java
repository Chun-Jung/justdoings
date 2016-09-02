package com.justdoings.act.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.justdoings.act.cate.model.ActCate;
import com.justdoings.act.loc.model.ActLoc;
import com.justdoings.organizer.model.Organizer;
import com.justdoings.status.code.model.StatusCode;

@Entity
@Table
public class Act {
	/** 活動編號 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer actSeq;
	
	/** 主辦單位 */
	@ManyToOne
	@JoinColumn(name="orgSeq")
	private Organizer organizer;
	
	@ManyToOne
	@JoinColumn(name="actCateSeq")
	/** 活動分類 */
	private ActCate actCate;
	
	/** 活動地區 */
	@ManyToOne
	@JoinColumn(name="actLocSeq")
	private ActLoc actLoc;
	
	/** 活動地址 */
	private String addr;
	
	/** 地址經度 */
	private Double addrLon;
	
	/** 地址緯度 */
	private Double addrLat;
	
	/** 標題 */
	private String title;
	
	/** 內容 */
	private String content;
	
	/** 簡介 */
	private String profile;
	
	/** 注意事項 */
	private String attention;
	
	/** 退費方式 */
	private Integer refundsWay;
	
	/** 海報檔案名稱 */
	private String posterFileName;
	
	/** 活動網址(站外) */
	private String link;
	
	/** 短連結 */
	private String shortLink;
	
	/** 預設連結 */
	private String defaultLink;
	
	/** 開始時間 */
	private Date beginDt;
	
	/** 結束時間 */
	private Date endDt;
	
	/** 建立時間 */
	private Date createDt;
	
	/** 上架時間 */
	private Date onShelfDt;
	
	/** 是否公開售票資訊 */
	private Integer isPubInfo;
	
	/** 是否為公開活動 */
	private Integer isPubAct;
	
	/** 是否為推薦活動 */
	private Integer isRecom;
	
	/** 活動狀態 */
	private StatusCode status;

	public Integer getActSeq() {
		return actSeq;
	}

	public void setActSeq(Integer actSeq) {
		this.actSeq = actSeq;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public ActCate getActCate() {
		return actCate;
	}

	public void setActCate(ActCate actCate) {
		this.actCate = actCate;
	}

	public ActLoc getActLoc() {
		return actLoc;
	}

	public void setActLoc(ActLoc actLoc) {
		this.actLoc = actLoc;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Double getAddrLon() {
		return addrLon;
	}

	public void setAddrLon(Double addrLon) {
		this.addrLon = addrLon;
	}

	public Double getAddrLat() {
		return addrLat;
	}

	public void setAddrLat(Double addrLat) {
		this.addrLat = addrLat;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public Integer getRefundsWay() {
		return refundsWay;
	}

	public void setRefundsWay(Integer refundsWay) {
		this.refundsWay = refundsWay;
	}

	public String getPosterFileName() {
		return posterFileName;
	}

	public void setPosterFileName(String posterFileName) {
		this.posterFileName = posterFileName;
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

	public String getDefaultLink() {
		return defaultLink;
	}

	public void setDefaultLink(String defaultLink) {
		this.defaultLink = defaultLink;
	}

	public Date getBeginDt() {
		return beginDt;
	}

	public void setBeginDt(Date beginDt) {
		this.beginDt = beginDt;
	}

	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getOnShelfDt() {
		return onShelfDt;
	}

	public void setOnShelfDt(Date onShelfDt) {
		this.onShelfDt = onShelfDt;
	}

	public Integer getIsPubInfo() {
		return isPubInfo;
	}

	public void setIsPubInfo(Integer isPubInfo) {
		this.isPubInfo = isPubInfo;
	}

	public Integer getIsPubAct() {
		return isPubAct;
	}

	public void setIsPubAct(Integer isPubAct) {
		this.isPubAct = isPubAct;
	}

	public Integer getIsRecom() {
		return isRecom;
	}

	public void setIsRecom(Integer isRecom) {
		this.isRecom = isRecom;
	}

	public StatusCode getStatus() {
		return status;
	}

	public void setStatus(StatusCode status) {
		this.status = status;
	}
	
}
	
	
