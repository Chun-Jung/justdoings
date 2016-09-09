package com.justdoings.status.code.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("statusCodeService")
public class StatusCodeServiceImpl implements StatusCodeService {
	
	@Autowired StatusCodeDao statusCodeDao;

	@Override
	@Transactional(readOnly = true)
	public StatusCode findBy(StatusEnum statusEnum, Integer code) {
		StatusCodeId primaryKey = new StatusCodeId();
		primaryKey.setStatusSeq(statusEnum.ordinal());
		primaryKey.setCode(code);
		return statusCodeDao.findBy(primaryKey);
	}

}
