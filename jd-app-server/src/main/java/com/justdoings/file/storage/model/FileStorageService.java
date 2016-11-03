package com.justdoings.file.storage.model;

import com.justdoings.status.code.model.StatusEnum;

public interface FileStorageService {
	/**
	 * 新增檔案
	 * @param statusEnum 狀態碼代號
	 * @param name 檔名
	 */
	void save(StatusEnum statusEnum, String name);
	
	/**
	 * 找檔案
	 * @param statusEnum 狀態碼代號
	 * @param name 檔名
	 * @return FileStorage
	 */
	FileStorage findByFileName(StatusEnum statusEnum, String name);
}
