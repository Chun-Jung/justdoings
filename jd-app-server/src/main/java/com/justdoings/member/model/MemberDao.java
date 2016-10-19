package com.justdoings.member.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface MemberDao extends CrudRepository<Member, Integer> {
	/**
	 * 用email搜尋會員
	 * @param email 會員信箱(帳號)
	 * @return Member
	 */
	Member findByEmail(String email);
}
