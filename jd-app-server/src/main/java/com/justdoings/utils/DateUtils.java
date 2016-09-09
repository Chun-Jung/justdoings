package com.justdoings.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static Date getDate(int year, int month, int day){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		return calendar.getTime();
	}
	
	public static Date getDate(int year, int month, int day, int hourOfDay, int minute, int second){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day, hourOfDay, minute, second);
		return calendar.getTime();
	}
	
	public static Date getMinDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date getMaxDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}
}
