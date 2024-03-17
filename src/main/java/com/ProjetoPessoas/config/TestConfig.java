package com.ProjetoPessoas.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ProjetoPessoas.Repositories.*;
import com.ProjetoPessoas.entities.*;



@Configuration
@Profile("test") 
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private TelefoneRepository telefoneRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa(null, "jao", "123", "jao@gmail.com", Instant.parse("2019-06-20T19:53:07Z"));
		Pessoa p2 = new Pessoa(null, "jao2", "456", "jao2@gmail.com", Instant.parse("2019-06-21T19:53:07Z"));
		
		Endereco e1 = new Endereco(null,"R. jorjao da silva", "mocreia", "dromedario", "sao paulo", "predio amarelo banana", 12, "1123-1233", p1);
		Endereco e2 = new Endereco(null,"R. jorjao da silva", "mocreia", "dromedario", "sao paulo", "predio amarelo banana", 13, "1123-1233", p2);
		
		Telefone t1 = new Telefone(null, "numero principal", 123456789, p1);
		Telefone t2 = new Telefone(null, "numero principal", 987456321, p2);
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		telefoneRepository.saveAll(Arrays.asList(t1, t2));

	}
}
