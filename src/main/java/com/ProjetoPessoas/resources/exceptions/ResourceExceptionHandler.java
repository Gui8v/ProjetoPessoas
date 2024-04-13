package com.ProjetoPessoas.resources.exceptions;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ProjetoPessoas.Services.Exception.ResourceBadRequest;
import com.ProjetoPessoas.Services.Exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private GlobalExceptionHandler globalExceptionHandler;
	
	@Autowired
	private ErrorComponent errorComponent;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
		
		String error = "Pessoa não encontrada";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = globalExceptionHandler.criarStandardError(Instant.now(), status.value(), error, e.getMessage()).build();
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ResourceBadRequest.class)
	public ResponseEntity<Object> resourceBadRequest(ResourceBadRequest e, WebRequest request){
		
		String error = "Dados não preenchidos corretamente : ";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = errorComponent.gerarErroParaRegraDeNegocio(e);
		err.setStatus(status.value());
		err.setTimestamp(Instant.now());
		err.setError(error);
		err.setIp(request.getRemoteUser());
		
		return this.retornarException(err, status);
	}
	
	
	
	private ResponseEntity<Object> retornarException(StandardError error, HttpStatusCode httpStatusCode) {
        return ResponseEntity.status(httpStatusCode).body(error);
    }
}
