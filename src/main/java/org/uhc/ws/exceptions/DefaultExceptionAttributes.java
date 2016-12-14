package org.uhc.ws.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

public class DefaultExceptionAttributes implements ExceptionAttributes {
	
	private static final String TIMESTAMP = "timestamp";
	private static final String EXCEPTION = "exception";
	private static final String STATUS = "status";
	private static final String MESSAGE = "message";
	private static final String ERROR = "error";
	private static final String PATH = "path";
	

	@Override
	public Map<String, Object> getExceptionAttributes(Exception exception, HttpServletRequest request,
			HttpStatus status) {
		Map<String,Object> exceptionAttributes = new HashMap<String,Object>();
		exceptionAttributes.put(TIMESTAMP, new Date());
		exceptionAttributes.put(EXCEPTION, exception.getClass().getName());
		exceptionAttributes.put(MESSAGE, exception.getMessage());
		exceptionAttributes.put(STATUS, status.value());
		exceptionAttributes.put(ERROR, status.getReasonPhrase());
		exceptionAttributes.put(PATH, request.getServletPath());
		return exceptionAttributes;
	}

}
