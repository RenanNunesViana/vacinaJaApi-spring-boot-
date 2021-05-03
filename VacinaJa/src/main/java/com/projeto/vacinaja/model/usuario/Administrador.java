package com.projeto.vacinaja.model.usuario;

public class Administrador extends Funcionario {
	
	public Administrador() {
		
	}
	
	/*US-01 -  Persistência dos dados armazenados;*/
	
	/*So ilustrativao.Creio que não existe este método na prática. É só configuração;*/
	/*US-03*/public void acessarSistemaHeroku() {  
	}
	
	/*US-04*/ public String aprovarCadastroFuncionario() {
		String output = "";
		return output;
	}
	
	/*US-05*/public void cadastrarTipoVacina(String fabricante,int numeroDosesNecessarias, 
			String tempoEntreDoses) {
	}
}
