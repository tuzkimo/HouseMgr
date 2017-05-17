package cn.jbit.house.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tool {

	public static Date strToDate(String dateStr, String pattern) throws ParseException {
		DateFormat dFmt = new SimpleDateFormat(pattern);
		Date date = dFmt.parse(dateStr);
		return date;
	}
	
	// 获取与当前日期前后相隔若干月的日期对象
	public static Date getDate(int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, num);
		Date date = calendar.getTime();
		return date;
	}
	
}
