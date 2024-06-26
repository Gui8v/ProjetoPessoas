package com.ProjetoPessoas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ProjetoPessoas.Services.PessoaService;
import com.ProjetoPessoas.Services.Exception.ResourceBadRequest;
import com.ProjetoPessoas.entities.Pessoa;



@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> list = service.findAll();
				
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id){
		Pessoa obj = service.findById(id);
				
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Pessoa> insertPessoa(@RequestBody Pessoa obj) throws ResourceBadRequest{		
		String validador = service.validarPessoa(obj);
		
		if(validador == null) {
			
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(obj);
		}
		else {
			throw new ResourceBadRequest(validador); 
		}
				
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id,@RequestBody Pessoa obj){
		obj = service.update(id, obj);
		
		return ResponseEntity.ok().body(obj);
	}
}
