package com.ProjetoPessoas.resources.exceptions;

import java.time.Instant;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Component(value = "GlobalExceptionHandler")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String MSG_ERRO_GENERICA_USUARIO_FINAL = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se o problema persistir, entre em contato com o administrador do sistema.";

    public StandardError.StandardErrorBuilder criarStandardError(Instant timestamp, Integer status, String error, String message) {
        return StandardError.builder().timestamp(timestamp).status(status).error(error).message(message);
        		
            
    }
}
