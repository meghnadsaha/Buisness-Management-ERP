package com.jcb.erp.cron;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jcb.erp.utils.DateUtility;
import com.jcb.erp.utils.DocumentType;

@Component
@Profile("dev") // for testing in dev whether it's working or not
public class JcbCronSchedular {
	private static final Logger LOGGER = LoggerFactory.getLogger(JcbCronSchedular.class);

	// @Autowired
	// private ReportUtility reportUtility;
	// @Autowired
	// EmailUtils emailUtils;

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");

	/*
	 * 
	 * This scheduler should be triggered at 05:10:00am every day -> 0 10 5 ?
	 * 
	 */
	@Async("asyncTaskExecutorForJcb")
	@Scheduled(cron = "${jobs.expression.for.jcb}")
	public void sendReportForRATeamCron() {

		String fromDayDate = DateUtility.getYesterdayDate();
		String toDayDate = DateUtility.getYesterdayDate();
		LOGGER.info("sendReportForRATeamCron() Scheduler called for date range  {} to {} ", fromDayDate, toDayDate);
		try {
//			reportUtility.setEmailConfigurationBoolean(reportUtility.getReportForRATeam(
//					reportUtility.getReportTemplateDetails(DocumentType.JCB_REPORT).getHeaders(), fromDayDate,
//					toDayDate), DocumentType.JCB_REPORT, fromDayDate, toDayDate);
		} catch (Exception e) {
			LOGGER.error("Exception occured while calling sendReportForRATeamCron() for report-type {} due to {} ",
					DocumentType.JCB_REPORT, e);
		}

	}

}