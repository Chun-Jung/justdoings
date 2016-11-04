package com.justdoings.file.storage.model;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.justdoings.status.code.model.StatusEnum;
import com.justdoings.utils.DateUtils;

public class FileStorageServiceImpl implements FileStorageService {
	private static final String FILE_STORAGE_DIR_ROOT = "D:/";
	
	@Autowired
	private FileStorageDao fileStorageDao;

	@Override
	@Transactional
	public String save(StatusEnum statusEnum, String name, byte[] data) throws IOException {
		Date now = new Date();
		// 資料夾路徑為 root/status/yyyy/MM/dd
		String folderPath = FILE_STORAGE_DIR_ROOT + statusEnum.name() + "/" + DateUtils.getFormatDate(now, "yyyy/MM/dd");
		File folder = new File(folderPath);
		if(!folder.exists()){
			folder.mkdirs();
		}
		
		FileStorage fileStorage = new FileStorage();
		fileStorage.setPath(folderPath);
		fileStorageDao.save(fileStorage);
		
		String extension = StringUtils.EMPTY;
		if(name.lastIndexOf('.') > StringUtils.INDEX_NOT_FOUND){
			extension = name.substring(name.lastIndexOf('.'));
		}
		// 檔名為 timestamp_fileSeq.extension
		String fileName = String.format("%d_%d", now.getTime(), fileStorage.getFileSeq() + extension);
		File file = new File(folder, fileName);
		if(!file.exists()){
			file.createNewFile();
		}
		FileUtils.writeByteArrayToFile(file, data);
		
		// 將檔名押回去
		fileStorage.setName(fileName);
		fileStorageDao.save(fileStorage);
		return fileName;
	}
	
	@Override
	@Transactional(readOnly = true)
	public FileStorage findByFileName(StatusEnum statusEnum, String name) {
		FileStorage fileStorage = fileStorageDao.findByName(name);
		return null;
	}
}
