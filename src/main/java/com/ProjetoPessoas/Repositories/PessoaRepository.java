package com.ProjetoPessoas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoPessoas.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	
}
