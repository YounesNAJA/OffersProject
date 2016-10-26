package com.joyuri.web.Controllers;

import org.springframework.dao.DataAccessException;
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
		exception.printStackTrace();
		return "error";
	}
}
