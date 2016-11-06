package com.justdoings.ad.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.justdoings.act.model.Act;

@Transactional(propagation = Propagation.MANDATORY)
public interface AdDao extends CrudRepository<Ad, Integer> {
	@Query("SELECT A FROM Ad A WHERE A.effectBeginDt >= ?1 AND A.effectEndDt <= ?1")
	List<Ad> findEffectAd(Date now);
	
	@Query("SELECT A.act FROM Ad A WHERE A.effectBeginDt >= ?1 AND A.effectEndDt <= ?1")
	List<Act> findEffectAdAct(Date now);
}
