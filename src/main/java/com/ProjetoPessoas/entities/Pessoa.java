package com.ProjetoPessoas.entities;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable{
	
		private static final long serialVersionUID = 1L;
	
		private Long id;
		private String nome;
		private int cpf;
		private String email;
		
		public Pessoa() {
			
		}

		public Pessoa(Long id, String nome, int cpf, String email) {
			super();
			this.id = id;
			this.nome = nome;
			this.cpf = cpf;
			this.email = email;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getCpf() {
			return cpf;
		}

		public void setCpf(int cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pessoa other = (Pessoa) obj;
			return Objects.equals(id, other.id);
		}
		
		
		
}
