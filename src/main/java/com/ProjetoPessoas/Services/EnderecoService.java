package com.ProjetoPessoas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoPessoas.Repositories.EnderecoRepository;
import com.ProjetoPessoas.entities.Endereco;


@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		return repository.findAll();
	}
	
	public Endereco findById(Long id){
		Optional<Endereco> obj = repository.findById(id);
		return obj.get();
	}
}
