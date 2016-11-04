package com.justdoings.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {
	private static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	
	/**
	 * 依輸入參數取得日期
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @return Date
	 */
	public static Date getDate(int year, int month, int day){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		return calendar.getTime();
	}
	
	/**
	 * 依輸入參數取得日期
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @param hourOfDay 時
	 * @param minute 分
	 * @param second 秒
	 * @return Date
	 */
	public static Date getDate(int year, int month, int day, int hourOfDay, int minute, int second){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day, hourOfDay, minute, second);
		return calendar.getTime();
	}
	
	/**
	 * 將日期轉換為當日最早時刻
	 * @param date 日期
	 * @return Date
	 */
	public static Date getMinDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 將日期轉換為當日最晚時刻
	 * @param date 日期
	 * @return Date
	 */
	public static Date getMaxDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}
	
	/**
	 * 取得格式化的日期
	 * @param date 日期
	 * @param format 格式
	 * @return String
	 */
	public static String getFormatDate(Date date, String format){
		format = StringUtils.isBlank(format) ? DEFAULT_DATE_FORMAT: format;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
