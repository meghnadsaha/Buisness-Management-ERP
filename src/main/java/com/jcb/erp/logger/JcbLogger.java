package com.jcb.erp.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

public class JcbLogger {
	private static final Logger logger = LoggerFactory.getLogger(JcbLogger.class);

	private static DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	/*
	 * public static void logRequest(LoggerEventType type, Object logObject)
	 * throws Exception { logRequest(type, logObject, null); }
	 */
	public static void log(boolean isRequest, boolean isException, LoggerEventType type, Object logObject)
			throws Exception {
		if (isRequest)
			logRequest(isException, type, logObject, null);
		else
			logResponse(isException, type, logObject, null);
	}

	public static void logRequest(boolean isException, LoggerEventType type, Object logObject, Long latency)
			throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JcbLoggingObject loggingObject = new JcbLoggingObject();
		loggingObject.setEventName(type.name());
		loggingObject.setLatency(latency);
		loggingObject.setTimeStamp(df.format(new Date()));
		loggingObject.setData(mapper.readTree(logObject.toString()));
		try {
			if (isException)
				logger.error(mapper.writeValueAsString(loggingObject));
			else
				logger.info(mapper.writeValueAsString(loggingObject));
		} catch (JsonProcessingException e) {
			logger.error("error while logging for event type {}", type);
		}
	}

	public static void logResponse(boolean isException, LoggerEventType type, Object logObject, Long latency)
			throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JcbLoggingObject loggingObject = new JcbLoggingObject();
		loggingObject.setEventName(type.name());
		loggingObject.setLatency(latency);
		loggingObject.setTimeStamp(df.format(new Date()));
		loggingObject.setData(logObject);
		try {
			if (isException)
				logger.error(mapper.writeValueAsString(loggingObject));
			else
				logger.info(mapper.writeValueAsString(loggingObject));
		} catch (JsonProcessingException e) {
			logger.error("error while logging for event type {}", type);
		}
	}

	@Setter
	static class ExceptionLog {
		private String exceptionName;
		private String exceptionMessage;
		private String stackTrace;
		private String causeException;
	}
}
