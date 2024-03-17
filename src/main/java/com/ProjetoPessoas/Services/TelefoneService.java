package com.ProjetoPessoas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoPessoas.Repositories.TelefoneRepository;
import com.ProjetoPessoas.entities.Telefone;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository repository;
	
	public List<Telefone> findAll(){
		return repository.findAll();
	}
	
	public Telefone findById(Long id){
		Optional<Telefone> obj = repository.findById(id);
		return obj.get();
	}
}
