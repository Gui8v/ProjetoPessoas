package com.ProjetoPessoas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoPessoas.Services.EnderecoService;
import com.ProjetoPessoas.Services.TelefoneService;
import com.ProjetoPessoas.entities.Endereco;
import com.ProjetoPessoas.entities.Telefone;

@RestController
@RequestMapping(value = "/telefones")
public class TelefoneResource {
	
	@Autowired
	private TelefoneService service;
	
	@GetMapping
	public ResponseEntity<List<Telefone>> findAll(){
		List<Telefone> list = service.findAll();
				
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Telefone> findById(@PathVariable Long id){
		Telefone obj = service.findById(id);
				
		return ResponseEntity.ok().body(obj);
	}
}
