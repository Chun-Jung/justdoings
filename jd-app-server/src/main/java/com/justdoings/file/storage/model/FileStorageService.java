package com.justdoings.file.storage.model;

import java.io.IOException;

import com.justdoings.status.code.model.StatusEnum;

public interface FileStorageService {
	/**
	 * 新增檔案
	 * @param statusEnum 狀態碼代號
	 * @param name 檔名
	 * @param data 資料
	 * @return String 處理過後的檔名
	 * @throws IOException 建立檔案或儲存檔案時發生例外
	 */
	String save(StatusEnum statusEnum, String name, byte[] data) throws IOException;

	/**
	 * 找檔案
	 * @param name 檔名
	 * @return byte[]
	 * @throws IOException 讀檔時發生例外
	 */
	byte[] findByFileName(String name);
	
	/**
	 * 取得預設影像
	 * @param imgNo 預設影像編號
	 * @return byte[]
	 * @throws IOException 讀檔時發生例外
	 */
	byte[] getDefaultImg(String imgNo);
}
