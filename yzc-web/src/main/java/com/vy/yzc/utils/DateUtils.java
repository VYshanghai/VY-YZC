package com.vy.yzc.utils;

import com.google.common.collect.Lists;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Edward
 * @Date: 2020/11/23 15:24
 * @Description:
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	private static final DateTimeFormatter standardDTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static final DateTimeFormatter simpleCronDTF = DateTimeFormatter.ofPattern("ss mm HH dd MM ? yyyy");
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static String getCurrentTime(){
		return LocalDateTime.now().format(standardDTF);
	}

	/**
	 * 获取当天开始时间
	 *
	 * @return String
	 */
	public static String getTodayStart() {
		LocalDateTime todayStart = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
		return todayStart.format(standardDTF);
	}

	/**
	 * 获取当天结束时间
	 *
	 * @return String
	 */
	public static String getTodayEnd() {
		LocalDateTime todayStart = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
		return todayStart.format(standardDTF);
	}

	/**
	 * todo
	 * @param date
	 * @return
	 */
	public static synchronized String format(Date date){
		return sdf.format(date);
	}


	/**
	 *java获取日期本周日时间接近24点时间
	 */
	public static Date getSundayOfThisWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getMondayOfThisWeek());
		cal.add(Calendar.DAY_OF_WEEK, 7);
		Instant instant = cal.getTime().toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		// atZone()方法返回在指定时区从此Instant生成的ZonedDateTime
		LocalDate lastWeekEndLocal = instant.atZone(zoneId).toLocalDate();
		LocalDateTime localDateTime = lastWeekEndLocal.atTime(23, 59, 59, 999);
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
		return  Date.from(zonedDateTime.toInstant());
	}


	/**
	 *java获取日期本周一时间0点时间
	 */
	public static Date getMondayOfThisWeek() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();

	}


	public static Long getTodayEndLong(){
		LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
		return todayEnd.toEpochSecond(ZoneOffset.of("+8"));
	}

	public static Long getTodayStartLong(){
		LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
		return todayEnd.toEpochSecond(ZoneOffset.of("+8"));
	}

	/**
	 * todo 校验一下
	 * @return
	 */
	public static synchronized List<String> findWeekDates(Date date){
		List<String> weeks = Lists.newArrayList();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		//获得当前日期是一个星期的第几天
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if(dayWeek==1){
			dayWeek = 8;
		}

		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);
		Date mondayDate = cal.getTime();
		String weekBegin = sdf.format(mondayDate);
		weeks.add(weekBegin);
		for (int i=1;i<=6;i++) {
			cal.add(Calendar.DAY_OF_WEEK, 1);
			weeks.add(format(cal.getTime()));
		}
		return weeks;
	}


	public static Date getLBeforeDate(Integer hour){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.HOUR_OF_DAY,hour);
		return c.getTime();
	}


	public static String getCron(LocalDateTime date){
		return date.format(simpleCronDTF);
	}

	public static Date getTodayZeroPointDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date transfer(Long time){
		if(Objects.isNull(time)){
			return null;
		}
		return new Date(time);
	}

	public static Boolean isWeekend(){
		Calendar cal=Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
	}

	public static Integer getHour() {
		Calendar cal=Calendar.getInstance();
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	public static Date setHour(Integer hour, Boolean last){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		if(last){
			calendar.add(Calendar.DATE,-1);
		}
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date addDay(Integer day){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}


/*
	public static void main(String[] args) {
		System.out.println(getCron(LocalDateTime.of(2019,3,4,23,6,2)));
		System.out.println(getMondayOfThisWeek());
		System.out.println(getSundayOfThisWeek());
	}
*/

}
