package com.ProjetoPessoas.resources.exceptions;

import org.springframework.stereotype.Component;

import com.ProjetoPessoas.Services.Exception.ResourceBadRequest;

@Component
public class ErrorComponent {
	
	
	public StandardError  gerarErroParaRegraDeNegocio(ResourceBadRequest rbr) {
		StandardError requestFeedback = new StandardError();
		requestFeedback.setMessage(rbr.getMensagem());
		
		return requestFeedback;
	}
}
