package com.shop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
	public static int dayForWeek(String pTime) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(format.parse(pTime));
			int dayForWeek = 0;
			if (c.get(Calendar.DAY_OF_WEEK) == 1) {
				dayForWeek = 7;
			} else {
				dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
			}
			return dayForWeek;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

