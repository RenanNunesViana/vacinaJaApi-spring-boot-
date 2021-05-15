package com.projeto.vacinaja.model.usuario;

import javax.persistence.Entity;
import com.projeto.vacinaja.model.estado.EstadoVacinacao;

@Entity
public class Funcionario extends Usuario {

	public String cargo;
	public String localTrabalho;
	public boolean aprovacao;

	public Funcionario() {
	}

	public Funcionario(Long id, String nomeCompleto, String endereco, String cpf, String email, String dataNascimento,
			String telefone, EstadoVacinacao estadoVacinacao, String comorbidade, String cargo, String localTrabalho) {
		super(nomeCompleto, endereco, cpf, email, dataNascimento, telefone, estadoVacinacao, comorbidade);
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
