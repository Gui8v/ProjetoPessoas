package com.ProjetoPessoas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoPessoas.Repositories.PessoaRepository;
import com.ProjetoPessoas.Services.Exception.ResourceNotFoundException;
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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Pessoa insert(Pessoa obj){
		return repository.save(obj);
	}
	
	public Pessoa update(Long id, Pessoa obj){
		Pessoa entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Pessoa entity, Pessoa obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setCpf(obj.getCpf());
		entity.setDataNascimento(obj.getDataNascimento());
		
	}
};
