package com.projeto.vacinaja.model.usuario;

import com.projeto.vacinaja.model.comorbidades.*;
import com.projeto.vacinaja.model.vacina.State;


public class Cidadao extends EstadoUsuario {
	
	private static Usuario usuario;
	public String id;
	public String nomeCompleto;
	public String endereco;
	public String cpf;
	public String numeroSUS;
	public String email;
	public String dataNascimento;
	public String telefone;
	public String profissao;
	public State estadoVacina;
	public String comorbidade;
	
	public Cidadao() {
		super(usuario);
	}
	
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
	
	//Se houver diferentes bancos, será necessário utilizar override neste método para cada tipo de user;
		/*US- 02 | 07 |12 */public void fazerLogin(String CPF) {  
	}

		
	/*US-15*/public State consultarMeuEstagioVacinacao() {
		return this.estadoVacina;
	}
		
	/*US-16 - Notificar os usuarios com msgm SMS quando estiverem habilitados;*/
		
	/*US-17*/public String agendarVacinacao() {
		String confirmacaoAgendamento = "";
		return confirmacaoAgendamento;
	}

	@Override
	public void loginCidadao(String login) {
		if(login.equals(this.id)) {
			usuario.changeState(new Cidadao());
		}
	}

	@Override
	public void loginFuncionario(String login) {
		// TODO Auto-generated method stub
	}

	@Override
	public void loginAdminstrador(String login) {
		// TODO Auto-generated method stub
	}
}
