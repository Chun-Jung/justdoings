package com.justdoings.act.model;

public interface ActDao {
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
	 * @param act 活動
	 */
	void delete(Act act);
	
	/**
	 * 查詢是否有重複的預設連結
	 * @param defaulLink 預設連結
	 * @return int
	 */
	int countBy(String defaulLink);
}
