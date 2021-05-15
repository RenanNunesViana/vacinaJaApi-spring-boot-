package com.projeto.vacinaja.model.usuario;

import java.util.Collection;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Usuario {

	public String cargo;
	public String localTrabalho;

	public Funcionario() {
	}

	

	public Funcionario(String nomeCompleto, String endereco, String cpf, String email, String dataNascimento,
			String telefone, String comorbidade, String cargo, String localTrabalho, String username, String password, Collection<Role> roles) {
		super(nomeCompleto, endereco, cpf, email, dataNascimento, telefone, comorbidade, username, password, roles);
		
		this.cargo = cargo;
		this.localTrabalho = localTrabalho;
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

}
