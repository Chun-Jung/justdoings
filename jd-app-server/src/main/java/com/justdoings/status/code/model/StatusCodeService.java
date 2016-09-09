package com.justdoings.status.code.model;

public interface StatusCodeService {
	/**
	 * 查詢狀態碼
	 * @param statusEnum 狀態碼編號列舉
	 * @param code 狀態碼代號
	 * @return StatusCode
	 */
	StatusCode findBy(StatusEnum statusEnum, Integer code);
}
