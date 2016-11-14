package com.justdoings.member.model;

public interface MemberService {
	/**
	 * 新增會員
	 * @param member 會員資料
	 */
	void saveOrUpdate(Member member);
	
	/**
	 * 用email搜尋會員
	 * @param email 會員信箱(帳號)
	 * @return Member
	 */
	Member findByEmail(String email);
	
	/**
	 * 用會員序號搜尋會員
	 * @param memSeq 會員序號
	 * @return Member
	 */
	Member findOne(Integer memSeq);
	
	/**
	 * 刪除會員
	 * @param member 會員主檔
	 * @return int
	 */
	void delete(Member member);
	
	/**
	 * 刪除會員
	 * @param memSeq 會員序號
	 * @return int
	 */
	void delete(Integer memSeq);
}
