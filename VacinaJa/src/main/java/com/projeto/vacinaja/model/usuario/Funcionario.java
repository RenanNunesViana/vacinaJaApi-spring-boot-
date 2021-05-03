package com.projeto.vacinaja.model.usuario;

public class Funcionario extends Usuario {
	public String cargo;
	public String localTrabalho;
	
	public Funcionario() {
		
	}
	
	/*US-08*/public void cadastrarLoteDeVacina(String validade, int numeroDoses, TipoVacina tipo) {
		
	}
	
	/*US-09*/public ArrayList<Vacina> listarDoses() {
		ArrayList<Vacina> lista = new ArrayList<Vacina>();
		return lista;
	}
	
	/*US-10*/public void habilitarCidadaoParaVacinacao(ArrayList<Cidadao> listaCidadaos,int dosesDisponiveis,
			String perfil) {
	}
	
	/*US-11*/public void registrarVacinacaoDeCidadao(String cpf,String dataVacinacao,int loteVacina,
			TipoVacina tipo,int numeroDose) {
	}
}
