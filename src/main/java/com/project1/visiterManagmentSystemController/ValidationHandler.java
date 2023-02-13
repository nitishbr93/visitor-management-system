package com.project1.visiterManagmentSystemController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders; 
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{
//	private ResponseEntity<Object> responseEntity;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
//		return super.handleMethodArgumentNotValid(ex, headers, status, request);
		Map<String, String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
		String fieldName=((FieldError)error).getField();
		String message=error.getDefaultMessage();
		errors.put(fieldName, message);
		});
//		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
		 ResponseEntity<Object> response1= new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
		return response1;
	}

}
