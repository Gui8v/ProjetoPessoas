package com.ProjetoPessoas.Services.Exception;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class ResourceBadRequest extends Exception implements Serializable{


	private static final long serialVersionUID = 1L;
	
	protected String mensagem;
	
	public ResourceBadRequest(String mensagem) {
		this.mensagem = mensagem;
	}
}
