package com.projeto.vacinaja.model.usuario;

import com.projeto.vacinaja.model.estado.EstadoVacinacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Usuario {
	
	@Id
	protected String cpf;
	protected String nomeCompleto;
	protected String endereco;
	protected String email;
	protected String dataNascimento;
	protected String telefone;
	protected String comorbidade;
	protected int idade;
	
	public Usuario() {
	}
	
	public Usuario(String nomeCompleto, String endereco, String cpf, String email, String dataNascimento,
			String telefone, String comorbidade) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.endereco = endereco;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
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
	
	public int getIdade() {
		return this.idade;
	}
}
