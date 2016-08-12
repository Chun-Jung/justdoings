package com.justdoings.ad.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/** 輪播編號 */
	private Integer adSeq;
	
	/** 活動 */
	private Integer actSeq;
	
	/** 輪播連結 */
	private String adUrl;
	
}
