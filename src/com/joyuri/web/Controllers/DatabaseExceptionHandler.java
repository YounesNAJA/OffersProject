package com.joyuri.web.Controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseExceptionHandler {
	/*
	 * =========================== 
	 * Database exception handling
	 * ==========================+
	 */
	@ExceptionHandler(DataAccessException.class)
	public String dbExceptionHandler(DataAccessException exception) {
		return "error";
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public String AccessDeniedExceptionHandler(AccessDeniedException exception) {
		return "denied";
	}
}
