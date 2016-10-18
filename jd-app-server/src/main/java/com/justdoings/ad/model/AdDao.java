package com.justdoings.ad.model;

public interface AdDao {
	/**
	 * 新增輪播活動
	 * @param ad 輪播活動
	 */
	void saveOrUpdate(Ad ad);
	
	/**
	 * 用PK搜尋輪播活動
	 * @param adSeq 輪播活動編號
	 * @return Ad 輪播活動
	 */
	Ad findOne(Integer adSeq);
	
	/**
	 * 刪除輪播活動
	 * @param adSeq 輪播活動編號
	 */
	void delete(Integer adSeq);
	
}
