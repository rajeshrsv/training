package com.training.student.util;

import org.apache.log4j.Logger;

public class LoggerUtil {

	public static Logger getInstance(Class<?> clazz) {
		return Logger.getLogger(clazz);
	}

}
