package com.justdoings.act.model;

public interface ActService {
	/**
	 * 新增活動
	 * @param act 活動
	 */
	void insert(Act act);
	
	/**
	 * 用活動編號搜尋活動
	 * @param actSeq 活動編號
	 * @return Act
	 */
	Act findBy(Integer actSeq);
	
	/**
	 * 更新活動
	 * @param act 活動
	 */
	void update(Act act);
	
	/**
	 * 刪除活動
	 * @param actSeq 活動編號
	 */
	void delete(Integer actSeq);
	
	/**
	 * 刪除活動
	 * @param act 活動編號封裝物件
	 */
	void delete(Act act);
	
	
	/**
	 * 查詢是否有重複的短連結
	 * @param shortLink 短連結
	 * @return int 筆數
	 */
	Long countBy(String shortLink);
}
