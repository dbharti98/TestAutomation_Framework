package com.saucedemo.helper;

import org.apache.log4j.Logger;

public class LogUtil {

	private static Logger logger;

	public static void logInfo(String message) {
		StackTraceElement ste = new Throwable().getStackTrace()[1];
		logger = Logger.getLogger("--");
		logger.info(message);
	}
}