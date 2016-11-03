package com.justdoings.file.storage.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface FileStorageDao extends CrudRepository<FileStorage, Integer> {
	
}
