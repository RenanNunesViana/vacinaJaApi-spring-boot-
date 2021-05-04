package com.projeto.vacinaja.model.usuario;

import java.util.ArrayList;

import com.projeto.vacinaja.model.vacina.TipoVacina;
import com.projeto.vacinaja.model.vacina.Vacina;

public class Funcionario extends EstadoUsuario {
	private static Usuario usuario;
	public String id;
	public String cargo;
	public String localTrabalho;
	
	public Funcionario() {
		super(usuario);
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
	public void loginCidadao(String login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loginFuncionario(String login) {
		if(login.equals(this.id)) {
			usuario.changeState(new Funcionario());
		}	
	}

	@Override
	public void loginAdminstrador(String login) {
		// TODO Auto-generated method stub
		
	}
}
