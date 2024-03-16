package com.ProjetoPessoas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ProjetoPessoas.Repositories.PessoaRepository;
import com.ProjetoPessoas.entities.Pessoa;

@Configuration
@Profile("test") 
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa(null, "jao", "123", "jao@gmail.com");
		Pessoa p2 = new Pessoa(null, "jao2", "456", "jao2@gmail.com");
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
	}
}
