package com.justdoings.file.storage.model;

import java.io.IOException;

import com.justdoings.status.code.model.StatusEnum;

public interface FileStorageService {
	/**
	 * 新增檔案
	 * @param statusEnum 狀態碼代號
	 * @param name 檔名
	 * @param data 資料
	 * @exception IOException 建立檔案或儲存檔案時發生例外
	 * @return String 處理過後的檔名
	 */
	String save(StatusEnum statusEnum, String name, byte[] data) throws IOException;
	
	/**
	 * 找檔案
	 * @param statusEnum 狀態碼代號
	 * @param name 檔名
	 * @return FileStorage
	 */
	FileStorage findByFileName(StatusEnum statusEnum, String name);
}
