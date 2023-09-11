package com.example.demo.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.DatasourceNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DatasourceNotFoundException.class)
	public Map<String, String> handleDatasourceNotFoundException(DatasourceNotFoundException e){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("error_message", e.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public Map<String, String> handleMissingRequestParamException(MissingServletRequestParameterException e){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("error_message", "query parameter is missing: "+e.getParameterName());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingRequestHeaderException.class)
	public Map<String, String> handleMissingRequestHeaderException(MissingRequestHeaderException e){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("error_message", "Request Header is missing: "+e.getHeaderName());
		return errorMap;
	}
	
}
