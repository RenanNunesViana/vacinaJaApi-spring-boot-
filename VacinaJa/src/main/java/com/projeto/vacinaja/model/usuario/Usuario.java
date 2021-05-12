package com.projeto.vacinaja.model.usuario;

import com.projeto.vacinaja.model.estado.EstadoVacinacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Usuario {
	
	@Id
	@GeneratedValue
	public Long id;
	public String nomeCompleto;
	public String endereco;
	public String cpf;
	public String email;
	public String dataNascimento;
	public String telefone;
	public String comorbidade;
	
	public Usuario() {
	}
	
	public Usuario(String nomeCompleto, String endereco, String cpf, String email, String dataNascimento,
			String telefone, EstadoVacinacao estadoVacinacao, String comorbidade) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.endereco = endereco;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}
	
	public Usuario(Long id, String nomeCompleto, String endereco, String cpf, String email, String dataNascimento,
			String telefone, EstadoVacinacao estadoVacinacao, String comorbidade) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.endereco = endereco;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getComorbidade() {
		return comorbidade;
	}
}
