package org.uhc.ws.api;

import java.util.Map;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.uhc.ws.exceptions.DefaultExceptionAttributes;
import org.uhc.ws.exceptions.ExceptionAttributes;

public class BaseController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,Object>> handleException(Exception exception,HttpServletRequest request){
		ExceptionAttributes exceptionAttribute = new DefaultExceptionAttributes();
		Map<String,Object> responseEntity = exceptionAttribute.getExceptionAttributes(exception, request, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<Map<String,Object>>(responseEntity,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(NoResultException.class)
	public ResponseEntity<Map<String,Object>> handleNoResultException(Exception exception,HttpServletRequest request){
		ExceptionAttributes exceptionAttribute = new DefaultExceptionAttributes();
		Map<String,Object> responseEntity = exceptionAttribute.getExceptionAttributes(exception, request, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<Map<String,Object>>(responseEntity,HttpStatus.NOT_FOUND);
		
	}
}
