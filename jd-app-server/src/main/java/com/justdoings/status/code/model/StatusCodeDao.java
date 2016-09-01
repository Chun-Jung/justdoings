package com.justdoings.status.code.model;

public interface StatusCodeDao {
	/**
	 * 查詢狀態碼
	 * @param primaryKey 主鍵封裝物件
	 * @return StatusCode
	 */
	StatusCode findBy(StatusCodeId primaryKey);
}
