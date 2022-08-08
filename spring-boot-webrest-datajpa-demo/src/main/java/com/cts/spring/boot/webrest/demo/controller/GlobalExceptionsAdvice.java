package com.cts.spring.boot.webrest.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.spring.boot.webrest.demo.exception.OperationFailedException;

@RestControllerAdvice
public class GlobalExceptionsAdvice {

	private Logger logger;
	
	public GlobalExceptionsAdvice() {
		logger = LoggerFactory.getLogger(this.getClass());
	}
	
	@ExceptionHandler({HttpMessageNotReadableException.class,OperationFailedException.class})
	public ResponseEntity<String> handleBadReqeustExceptions(Throwable exp){
		logger.error(exp.getMessage(), exp);
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleInternalServerErrorExceptions(Throwable exp){
		logger.error(exp.getMessage(), exp);
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
