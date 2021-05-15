package com.projeto.vacinaja.model.usuario;

import com.projeto.vacinaja.model.Notificavel;
import com.projeto.vacinaja.model.estado.EstadoVacinacao;
import com.projeto.vacinaja.model.vacina.CarteiraVacinacao;
import com.sun.istack.NotNull;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;


@Entity
public class Cidadao extends Usuario implements Notificavel{
	
	private String numeroSUS;
	private String profissao;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private EstadoVacinacao estadoVacinacao;

	@OneToOne(cascade=CascadeType.PERSIST)
	private CarteiraVacinacao carteiraVacinacao;
 
	public Cidadao() {
		
	}
	
	public Cidadao(String nome, String endereco, String cpf, String email, String dataNascimento, String telefone,
				String numeroSUS, String profissao, String username, String password, Collection<Role> roles) {
				
		super(nome, endereco, cpf, email, dataNascimento, telefone, "", username, password, roles);
		this.numeroSUS = numeroSUS;
		this.profissao = profissao;
		this.carteiraVacinacao = new CarteiraVacinacao();
		this.estadoVacinacao = EstadoVacinacao.NAO_HABILITADO;
	}

	public void alterarEstadoVacinacao(EstadoVacinacao novoEstadoVacinacao) {
		this.estadoVacinacao = novoEstadoVacinacao;
	}

	public void alteraNomeCompleto(String novoNome) {
		super.nomeCompleto = novoNome;
	}
	public void alteraEndereco(String novoEndereco) { 
		this.endereco = novoEndereco;
	}
	public void alteraCPF(String novoCPF) { 
		this.cpf = novoCPF;
	}
	public void alteraNumeroSUS(String novoNumeroSUS) { 
		this.numeroSUS = novoNumeroSUS;
	}
	public void alteraEmail(String novoEmail) { 
		this.email = novoEmail;
	}
	public void alteraDataNascimento(String novaDataNascimento) { 
		this.dataNascimento = novaDataNascimento;
	}
	public void alteraTelefone(String novoTelefone) { 
		this.telefone = novoTelefone;
	}
	public void alteraProfissao(String novaProfissao) { 
		this.profissao = novaProfissao;
	}
	
	public String getNumeroSUS() {
		return numeroSUS;
	}
	public String getEmail() {
		return email;
	}
	public String getProfissao() {
		return profissao;
	}
	
	public EstadoVacinacao getEstadoVacinacao() {
		return estadoVacinacao;
	}

	public CarteiraVacinacao getCarteriaVacinacao() {
		return carteiraVacinacao;
	}

	@Override
	public void notifica() {
		this.estadoVacinacao.proximoEstado(this);
		
	}
}