package com.ProjetoPessoas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoPessoas.Repositories.EnderecoRepository;
import com.ProjetoPessoas.Repositories.PessoaRepository;
import com.ProjetoPessoas.Services.Exception.ResourceNotFoundException;
import com.ProjetoPessoas.entities.Endereco;
import com.ProjetoPessoas.entities.Pessoa;
import com.ProjetoPessoas.entities.dto.PessoaDto;

@Service
public class PessoaService extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}
	
	public Pessoa findById(Long id){
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Pessoa insert(Pessoa obj){
		
		populaPessoa(obj);
		
		repository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		
		return obj;
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
	
	public String validarPessoa(Pessoa obj) {
		String message = null;
	    String[] words = obj.getNome().split("\\s+");
		
		if(words.length <= 1) {
			message += "\n -Nome incompleto";
		}
				
		return message;
	}
	
	public PessoaDto tranfereDto(Pessoa obj, PessoaDto objDto) {
		
		objDto.setNome(obj.getNome());
		objDto.setDataNascimento(obj.getDataNascimento());
		objDto.setCpf(obj.getCpf());
		objDto.setEmail(obj.getEmail());
		objDto.setEnderecos(obj.getEnderecos());
		objDto.setTelefones(obj.getTelefones());
		
				
		return objDto;
	}
	
	private void populaPessoa(Pessoa pessoa) {
		
		for(Endereco endereco : pessoa.getEnderecos()) {
			endereco.setPessoa(pessoa);
		}
	}
	
}
