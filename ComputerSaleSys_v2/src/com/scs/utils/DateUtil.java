package com.scs.utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static Date str2date(String dateStr) throws ParseException {
		Date retDate = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		retDate = format.parse(dateStr);
		return retDate;
	}
	public static String date2str(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(date);
		return dateStr;
	}
	
	

	public static void main(String[] args) throws ParseException {
		System.out.println(DateUtil.date2str(DateUtil.str2date("2017-9-9")));
	}
}
