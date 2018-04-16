package com.bjgoodwill.insurance.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Package: com.bjgoodwill.insurance.util
 * @Decription 年龄处理工具{653dd1f2-4fd3-4af6-96b6-0dac66917a4f}
 * @author zhangq 
 * @date 2018年3月26日 下午5:05:39
 */
public class AgeHelper {

	/**
	 * 获取年龄
	 * @param birthday 生日
	 * @return 年龄
	 */
	public static String getAge(Date birthday) {
		Date dateNow = new Date();
		long endTime = dateNow.getTime();
		long startTime = birthday.getTime();
		int days = (int)((endTime - startTime) / (1000 * 60 * 60 * 24));
		if (days <= 28) {
			return String.valueOf(days);
		} else {
			Calendar calBegin = Calendar.getInstance();
			Calendar calEnd = Calendar.getInstance();  
			calBegin.setTime(birthday);
			calEnd.setTime(dateNow);
			int nMonth = (calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR)) * 12 + calEnd.get(Calendar.MONTH) - calBegin.get(Calendar.MONTH);
			if (nMonth < 36) {
				return String.valueOf(nMonth);
			}
			return String.valueOf(calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR));
		}
	}
	
	/**
	 * 获取年龄单位
	 * 0:周岁；1：月；2：天
	 * @param birthday 生日
	 * @return 返回年龄单位（0:周岁；1：月；2：天）
	 */
	public static String getAgeUnit(Date birthday) {
		Date dateNow = new Date();
		long endTime = dateNow.getTime();
		long startTime = birthday.getTime();
		int days = (int)((endTime - startTime) / (1000 * 60 * 60 * 24));
		if (days <= 28) {
			return String.valueOf(2);
		} else {
			Calendar calBegin = Calendar.getInstance();
			Calendar calEnd = Calendar.getInstance();  
			calBegin.setTime(birthday);
			calEnd.setTime(dateNow);
			int nMonth = (calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR)) * 12 + calEnd.get(Calendar.MONTH) - calBegin.get(Calendar.MONTH);
			if (nMonth < 36) {
				return String.valueOf(1);
			}
			return String.valueOf(0);
		}
	}
	
	public static String getAge(String birthday) {
		return birthday.toString();
	}
	
	public static Date getAge(Date birthday, String name) {
		System.out.println("birthday:" + birthday.toString());
		System.out.println("name:" + name);
		return birthday;
	}
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(getAge(format.parse("2017-06-07")));
	}
}
