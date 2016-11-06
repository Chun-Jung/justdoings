package com.justdoings.ad.model;

import java.util.List;

import com.justdoings.act.model.Act;

public interface AdService {
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
	 * @param ad 輪播活動
	 */
	void delete(Ad ad);
	
	/**
	 * 刪除輪播活動
	 * @param adSeq 輪播活動編號
	 */
	void delete(Integer adSeq);
	
	/**
	 * 找出所有有效的輪播活動(effect_end_dt > now)
	 * @return List<Ad>
	 */
	List<Ad> findEffectAd();
	
	/**
	 * 找出所有有效的輪播活動(effect_end_dt > now)
	 * @return List<Act>
	 */
	List<Act> findEffectAct();
}
