package com.projeto.vacinaja.model.usuario;

import java.util.ArrayList;

import com.projeto.vacinaja.model.vacina.Vacina;

public class Funcionario implements Usuario {
	
	public String id;
	public String cargo;
	public String cpf;
	public String localTrabalho;
	
	public Funcionario() {
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void setLocalTrabalho(String cargo) {
		this.cargo = cargo;
	}
	
	/*US-08*/public void cadastrarLoteDeVacina(String validade, int numeroDoses, TipoVacina tipo) {
		
	}
	
	/*US-09*/public ArrayList<Vacina> listarDoses(ArrayList<Vacina> vacinas) {   
		return vacinas;
	}
	
	/*US-10*/public void habilitarCidadaoParaVacinacao(ArrayList<Cidadao> listaCidadaos,int dosesDisponiveis,
			String perfil) {
	}
	
	/*US-11*/public void registrarVacinacaoDeCidadao(String cpf,String dataVacinacao,int loteVacina,
			TipoVacina tipo,int numeroDose) {
	}

	@Override
	public void fazerLogin(String CPF) {
		// TODO Auto-generated method stub
	}
}
