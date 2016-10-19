package com.justdoings.act.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.justdoings.act.category.model.Category;
import com.justdoings.act.location.model.Location;
import com.justdoings.organizer.model.Organizer;
import com.justdoings.status.code.model.StatusCode;

@Entity
@Table
public class Act {
	/** 活動編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "act_seq")
	private Integer actSeq;

	/** 主辦單位 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "org_seq")
	private Organizer organizer;

	/** 活動地區 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "loc_seq")
	private Location location;

	/** 活動地址 */
	private String addr;

	/** 地址經度 */
	@Column(name = "addr_lon")
	private Double addrLon;

	/** 地址緯度 */
	@Column(name = "addr_lat")
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
	@Column(name = "refunds_way")
	private Integer refundsWay;

	/** 海報檔案名稱 */
	@Column(name = "poster_file_name")
	private String posterFileName;

	/** 活動網址(站外) */
	private String link;

	/** 短連結 */
	@Column(name = "short_link")
	private String shortLink;

	/** 開始時間 */
	@Column(name = "begin_dt")
	private Date beginDt;

	/** 結束時間 */
	@Column(name = "end_dt")
	private Date endDt;

	/** 建立時間 */
	@Column(name = "create_dt", insertable = false, updatable = false)
	private Date createDt;

	/** 上架時間 */
	@Column(name = "on_shelf_dt")
	private Date onShelfDt;

	@Column(name = "click_no", insertable = false)
	private Integer clickNo;

	/** 是否公開售票資訊 */
	@Column(name = "is_pub_info")
	private Integer isPubInfo;

	/** 是否為公開活動 */
	@Column(name = "is_pub_act")
	private Integer isPubAct;

	/** 是否為推薦活動 */
	@Column(name = "is_recomm", insertable = false)
	private Integer isRecomm;

	/** 活動狀態碼 */
	private Integer status;

	/** 活動狀態封裝物件 */
	@Transient
	private StatusCode statusCode;

	/** 活動分類 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "act_cate", joinColumns = @JoinColumn(name = "act_seq") , inverseJoinColumns = @JoinColumn(name = "cate_seq") )
	private List<Category> categories;

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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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

	public Integer getIsRecomm() {
		return isRecomm;
	}

	public void setIsRecomm(Integer isRecomm) {
		this.isRecomm = isRecomm;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Integer getClickNo() {
		return clickNo;
	}

	public void setClickNo(Integer clickNo) {
		this.clickNo = clickNo;
	}

}
