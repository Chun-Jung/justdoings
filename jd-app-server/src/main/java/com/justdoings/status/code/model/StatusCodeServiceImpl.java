package com.justdoings.status.code.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("statusCodeService")
public class StatusCodeServiceImpl implements StatusCodeService {
	@Autowired
	private StatusCodeDao statusCodeDao;
	
	@Override
	public StatusCode findOne(StatusEnum statusEnum, Integer code) {
		StatusCodeId codeId = new StatusCodeId();
		codeId.setStatusSeq(statusEnum.ordinal());
		codeId.setCode(code);
		return statusCodeDao.findOne(codeId);
	}
}
