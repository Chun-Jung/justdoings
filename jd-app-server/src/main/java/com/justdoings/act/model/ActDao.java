package com.justdoings.act.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface ActDao extends JpaRepository<Act, Integer> {
	/**
	 * 查詢短連結比數
	 * @param shortLink 短連結
	 * @return Long
	 */
	Long countByShortLink(String shortLink);
	
	/**
	 * 找出推薦的活動
	 * @param instructions 分頁條件
	 * @return Page<Act>
	 */
	Page<Act> findByisRecomm(Integer isRecomm, Pageable instructions);
	
	/**
	 * 計算收藏名單數
	 * @param actSeq 活動編號
	 * @return Integer
	 */
//	@Query("SELECT COUNT(C) FROM collecting C WHERE act_seq = ?1")
//	Integer countTrackingNumber(Integer actSeq);
}
