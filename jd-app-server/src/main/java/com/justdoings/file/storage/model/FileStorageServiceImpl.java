package com.justdoings.file.storage.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.justdoings.status.code.model.StatusEnum;

public class FileStorageServiceImpl implements FileStorageService {
	@Autowired
	private FileStorageDao fileStorageDao;

	@Override
	public void save(StatusEnum statusEnum, String name) {

	}

	@Override
	public FileStorage findByFileName(StatusEnum statusEnum, String name) {
		return null;
	}

}
