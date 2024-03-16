package com.ProjetoPessoas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoPessoas.Repositories.PessoaRepository;
import com.ProjetoPessoas.entities.Pessoa;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}
	
	public Pessoa findById(Long id){
		Optional<Pessoa> obj = repository.findById(id);
		return obj.get();
	}
}
