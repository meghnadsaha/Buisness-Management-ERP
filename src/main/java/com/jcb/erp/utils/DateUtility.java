package com.jcb.erp.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtility {
//	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtility.class);

	public static String getCurrentDateInYYYYMMDDHHMMSSZ() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

		Calendar cal = Calendar.getInstance();
		return formatter.format(cal.getTime());
	}

	public static String addingDaysToTheGivenDate(String startDate, int numberOfDaysToAdd) {
		// Specifying date format that matches the given date
		SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		Calendar c = Calendar.getInstance();
		try {
			// Setting the date to the given date
			c.setTime(sdf.parse(startDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, numberOfDaysToAdd);
		// Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		// Displaying the new Date after addition of Days

		return newDate;
	}

	public static  String getYesterdayDate() {

		// variable to store date in string format
		String yesterdayDate = "";
		// to get calendar instance
		Calendar cal = Calendar.getInstance();
		// subtract 1 from calendar current date
		cal.add(Calendar.DATE, -1);
		// format date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// get formatted date
		yesterdayDate = dateFormat.format(cal.getTime());

//		LOGGER.info("Yesterday's date is {} ", yesterdayDate);
		return yesterdayDate;
	}

}
