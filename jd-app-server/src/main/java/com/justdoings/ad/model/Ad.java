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
	/** �����s�� */
	private Integer adSeq;
	
	/** ���� */
	private Integer actSeq;
	
	/** �����s�� */
	private String adUrl;
	
}
