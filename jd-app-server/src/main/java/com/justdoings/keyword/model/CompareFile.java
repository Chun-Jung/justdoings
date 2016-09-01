package com.justdoings.keyword.model;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class CompareFile {

	public static void main(String[] args) throws IOException {
		List<String> files1 = Arrays.asList(new File("G:/imagepath_BACKUP").list());
		List<String> files2 = Arrays.asList(new File("F:/imagepath_BACKUP").list());
		System.out.println("舊");
		for(String file1 :files1){
			if(!files2.contains(file1)){
				System.out.println(file1);
			}
		}
		
		System.out.println("\r\n新");
		for(String file2 :files2){
			if(!files1.contains(file2)){
				System.out.println(file2);
			}
		}
		
		System.out.println("finish");
	}

}
