package com.justdoings.ad.model;

public interface AdDao {
	/**
	 * 新增輪播活動
	 * @param ad 輪播活動
	 */
	void insert(Ad ad);
	
	/**
	 * 用PK搜尋輪播活動
	 * @param adSeq 輪播活動編號
	 * @return Ad 輪播活動
	 */
	Ad findBy(Integer adSeq);
	
	/**
	 * 更新輪播活動
	 * @param ad 輪播活動
	 */
	void update(Ad ad);
	
	/**
	 * 刪除輪播活動
	 * @param ad 輪播活動
	 */
	void delete(Ad ad);
	
}
