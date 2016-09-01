/**
 * 程式資訊摘要：
 * 類別名稱：.java
 * 程式內容說明：
 * 版本資訊：
 * 程式設計人員姓名：
 * 程式修改記錄：20xx-xx-xx
 * 版權宣告：
 */
package com.justdoings.keyword.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

/**
 * @author Chun-Jung, Chen
 * 
 */
public class CarVsccUploadImageSqlGenerate {
    public static void main(String[] args) throws IOException {
	String rootPath = "G:/imagepath_BACKUP";
	String outputPath = "D:/CheckVsccImageUploadCarno_O.txt";
	String strFormat = "INSERT INTO car_vscc_image VALUES('%s', '%s', '%s', '%s', '%s');";
	String createDt = "2016-01-01 00:00:00";
	String updateDmv = "20";

	File rootFolder = new File(rootPath);
	if (!rootFolder.exists() || !rootFolder.isDirectory()) {
	    System.err.println("路徑不存在或路徑不為一個資料夾!");
	    return;
	}

	// 第一層-caseid
	File[] caseidFolders = null;
	// 第二層-車型代碼
	File[] carnoFolders = null;
	// 第三層-remark
	File[] remarkFiles = null;
	// 所有的carno
	Set<String> allOfSql = new HashSet<String>();
//	List<String> allOfSql = new ArrayList<String>();

	caseidFolders = rootFolder.listFiles();
	if (caseidFolders.length == 0) {
	    System.err.println("根目錄底下無其他檔案及路徑");
	    return;
	}

	// 第一層
	for (File caseidFolder : caseidFolders) {
	    if (!caseidFolder.isDirectory()) {
		continue;
	    }
	    carnoFolders = caseidFolder.listFiles();
	    if (carnoFolders == null) {
		continue;
	    }

	    String caseid = caseidFolder.getName();

	    // 第二層
	    for (File carnoFolder : carnoFolders) {
		if (!carnoFolder.isDirectory()) {
		    continue;
		}
		String carno = getCarnoModify(carnoFolder.getName());
		try{
			// 車型代號不得為數字
			int carnoInt = Integer.valueOf(carno);
			continue;
		}catch(NumberFormatException ignore){
			
		}

		StringBuilder remarkBilder = new StringBuilder();

		// 第三層
		
		remarkFiles = carnoFolder.listFiles();
		for (File remarkFile : remarkFiles) {
		    if (!remarkFile.isFile()) {
		    	continue;
		    }
		    String extendFileName = null;
		    try{
		    	extendFileName = remarkFile.getName().substring(remarkFile.getName().indexOf("."));
		    }catch(StringIndexOutOfBoundsException e){
		    	
		    }
		    if(!".jpg".equalsIgnoreCase(extendFileName) && !".jpeg".equalsIgnoreCase(extendFileName)){
		    	continue;
		    }
		    remarkBilder.append(remarkFile.getName() + ";");
		}
		
		if(remarkBilder.length() == 0){
			continue;
		}

		String[] params = new String[5];
		params[0] = caseid;
		params[1] = carno;
		params[2] = createDt;
		params[3] = updateDmv;
		params[4] = remarkBilder.toString();
		String sql = String.format(strFormat, params);
		String msg = caseid + ", " + carno;
		allOfSql.add(msg);
		System.out.println(msg);
		
		
	    }
	}

	File outputFile = new File(outputPath);
	FileUtils.writeLines(outputFile, allOfSql, System.getProperty("line.separator"));
	System.out.println("Finish");
    }

    /**
     * 某些車型代碼為少量型的格式，例如:
     * B5449D1605-01-05，第二個'-'在資料庫實際的資料為'/'，因為檔案系統不准使用'/'特殊符號，所以用'-'代替。
     * 所以發現這種少量型的車型代碼，因將'-'改為'/'回傳。
     * 
     * @param orignCarno
     *            原始的車型代碼
     * @return String
     */
    public static String getCarnoModify(String orignCarno) {
	int firstIndex = orignCarno.indexOf('-');
	int secondIndex = orignCarno.indexOf('-', firstIndex + 1);

	if (secondIndex != -1) {
	    StringBuilder stringBuilder = new StringBuilder(orignCarno);
	    stringBuilder.replace(secondIndex, secondIndex + 1, "/");
	    return stringBuilder.toString();
	}

	return orignCarno;
    }
}
