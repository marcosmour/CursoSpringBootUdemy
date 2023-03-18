package com.curso.Cursospring.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.curso.Cursospring.exceptions.ExceptionResponse;
import com.curso.Cursospring.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	// PARA OS RETORNOS MAIS COMUNS - PARA TODAS AS EXCESSOES
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExcception(Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}


// PARA O NOSSO METODO CRIADO
@ExceptionHandler(UnsupportedMathOperationException.class)
public final ResponseEntity<ExceptionResponse> handleBadRequestExcception(Exception ex, WebRequest request){
	
	ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	
	return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
}
}
