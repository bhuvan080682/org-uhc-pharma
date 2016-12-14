package org.uhc.ws.exceptions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

public interface ExceptionAttributes {
	Map<String,Object> getExceptionAttributes(Exception exception,HttpServletRequest request,HttpStatus status);
}
