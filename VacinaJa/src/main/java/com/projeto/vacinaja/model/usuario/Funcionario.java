package com.projeto.vacinaja.model.usuario;

import java.util.ArrayList;
import javax.persistence.Entity;
import com.projeto.vacinaja.model.estado.EstadoVacinacao;
import com.projeto.vacinaja.model.vacina.Vacina;

@Entity
public class Funcionario extends Usuario {
	
	public String cargo;
	public String localTrabalho;
	
	public Funcionario() {
	}
	
	public Funcionario(Long id, String nomeCompleto, String endereco, String cpf, String email, String dataNascimento,
			String telefone, EstadoVacinacao estadoVacinacao, String comorbidade, String cargo, String localTrabalho) {
		super(id, nomeCompleto, endereco, cpf, email, dataNascimento, telefone, estadoVacinacao, comorbidade);
		this.cargo = cargo;
		this.localTrabalho = localTrabalho;
	}



	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void setLocalTrabalho(String cargo) {
		this.cargo = cargo;
	}
	
	/*US-08*/public void cadastrarLoteDeVacina(String validade, int numeroDoses, String tipo) {
		
	}
	
	/*US-09*/public ArrayList<Vacina> listarDoses(ArrayList<Vacina> vacinas) {   
		return vacinas;
	}
	
	/*US-10*/public void habilitarCidadaoParaVacinacao(ArrayList<Cidadao> listaCidadaos,int dosesDisponiveis,
			String perfil) {
	}
	
	/*US-11*/public void registrarVacinacaoDeCidadao(String cpf,String dataVacinacao,int loteVacina,
			Vacina tipo,int numeroDose) {
	}
}
