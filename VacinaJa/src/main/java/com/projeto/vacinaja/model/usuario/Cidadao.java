package com.projeto.vacinaja.model.usuario;

public class Cidadao implements Usuario {
	
	public String id;
	public String nomeCompleto;
	public String endereco;
	public String cpf;
	public String numeroSUS;
	public String email;
	public String dataNascimento;
	public String telefone;
	public String profissao;
	//public EstadoVacinacao estadoVacinacao;
	public String comorbidade;
	
	/*US-14*/
	public void alteraNomeCompleto(String novoNome) {
		this.nomeCompleto = novoNome;
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
	
	public void fazerLogin(String CPF) {  
	}

//	/*US-15*/public EstadoVacinacao consultarMeuEstagioVacinacao() {
//		return this.estadoVacinacao;
//	}
		
	/*US-16 - Notificar os usuarios com msgm SMS quando estiverem habilitados;*/
		
	/*US-17*/public String agendarVacinacao() {
		String confirmacaoAgendamento = "";
		return confirmacaoAgendamento;
	}
}
