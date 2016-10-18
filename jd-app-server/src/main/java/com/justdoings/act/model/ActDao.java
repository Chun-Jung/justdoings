package com.justdoings.act.model;

public interface ActDao {
	/**
	 * 新增活動
	 * @param act 活動
	 */
	void saveOrUpdate(Act act);
	
	/**
	 * 用活動編號搜尋活動
	 * @param actSeq 活動編號
	 * @return Act
	 */
	Act findOne(Integer actSeq);

	/**
	 * 刪除活動
	 * @param act 活動
	 */
	void delete(Integer actSeq);
	
	/**
	 * 查詢是否有重複的短連結
	 * @param shortLink 短連結
	 * @return int 筆數
	 */
	Long countBy(String shortLink);
}
