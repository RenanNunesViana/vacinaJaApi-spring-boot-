package com.projeto.vacinaja.model.usuario;

import java.util.Collection;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Usuario {

	public String cargo;
	public String localTrabalho;
	public boolean aprovacao;

	public Funcionario() {
	}

	

	public Funcionario(String nomeCompleto, String endereco, String cpf, String email, String dataNascimento,
			String telefone, String comorbidade, String cargo, String localTrabalho, String username, String password, Collection<Role> roles) {
		super(nomeCompleto, endereco, cpf, email, dataNascimento, telefone, comorbidade, username, password, roles);
		
		this.cargo = cargo;
		this.localTrabalho = localTrabalho;
		this.aprovacao = false;
	}



	public String getCpf() {
		return this.cpf;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setLocalTrabalho(String cargo) {
		this.cargo = cargo;
	}

	public boolean getAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(boolean aprovacao) {
		this.aprovacao = aprovacao;
	}
	
	

}
