package com.projeto.vacinaja.model.usuario;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.projeto.vacinaja.model.Notificavel;
import com.projeto.vacinaja.model.estado.EstadoVacinacao;

@Entity
public class Cidadao extends Usuario implements Notificavel{
	
	public String numeroSUS;
	public String email;
	public String profissao;
	public String comorbidades;
	
	@OneToOne
	public EstadoVacinacao estadoVacinacao;


	public void alterarEstadoVacinacao(EstadoVacinacao novoEstadoVacinacao) {
		this.estadoVacinacao = novoEstadoVacinacao;
	}
	/*US-14*/
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
	
	// public void fazerLogin(String CPF) {  
	// }

	public String getNumeroSUS() {
		return numeroSUS;
	}
	public String getEmail() {
		return email;
	}
	public String getProfissao() {
		return profissao;
	}
	public String getComorbidades() {
		return comorbidades;
	}
	public EstadoVacinacao getEstadoVacinacao() {
		return estadoVacinacao;
	}

	// /*US-17*/public String agendarVacinacao() {
	// 	String confirmacaoAgendamento = "";
	// 	return confirmacaoAgendamento;
	// }

	@Override
	public void notifica() {
		// TODO Auto-generated method stub
		this.estadoVacinacao.atualizar();
		
	}
}