package com.justdoings.file.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.justdoings.file.storage.model.FileStorageService;

@Controller
@RequestMapping("file")
public class FileStorageController {
	@Autowired
	private FileStorageService fileStorageService;

	@RequestMapping("userupload/{fileName:.+}")
	@ResponseBody
	public byte[] findByFileName(@PathVariable("fileName") String fileName){
		return fileStorageService.findByFileName(fileName);
	}
	
	@RequestMapping("default/{imgNo:.+}")
	@ResponseBody
	public byte[] getDefaultImgByImgNo(@PathVariable("imgNo") String imgNo){
		return fileStorageService.getDefaultImg(imgNo);
	}
}
