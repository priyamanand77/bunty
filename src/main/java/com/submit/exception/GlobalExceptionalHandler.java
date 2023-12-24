package com.submit.exception;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.submit.response.Errors;

@RestControllerAdvice
public class GlobalExceptionalHandler {

	@ExceptionHandler(FormException.class)
	public ResponseEntity<Errors> sendRuntimeException(FormException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(	Errors.builder().status(HttpStatus.BAD_REQUEST.value()).message(exception.getMessage()).date(new Timestamp( new Date().getTime()))
				.build());
				
				
			

	}

}
