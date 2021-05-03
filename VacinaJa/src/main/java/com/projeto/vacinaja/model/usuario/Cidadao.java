package com.projeto.vacinaja.model.usuario;

import com.projeto.vacinaja.model.comorbidades.*;


public class Cidadao extends Usuario {
	
	public Cidadao(String nome,String endereco, String cpf,String numeroSUS,
			String email,String datanascimento,String telefone, String profissao, int option) {
		
		this.nomeCompleto = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.numeroSUS = numeroSUS;
		this.email = email;
		this.dataNascimento = datanascimento;
		this.telefone = telefone;
		this.profissao = profissao;
		
		TipoComorbidade tipoComorbidade = TipoComorbidade.values()[option - 1]; //Mostar quais opções de comorbidade;
		this.comorbidade = tipoComorbidade.getComorbidade();
		
		//this.estadoVacina = NaoHabilitado();  //Arrumar ao criar os estados da vacina;
	}
}
