package com.projeto.vacinaja.model.usuario;

public class Administrador extends EstadoUsuario {
	
	public String id;
	private static Usuario usuario;
	
	public Administrador() {
		super(usuario);
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

	@Override
	public void loginCidadao(String login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loginFuncionario(String login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loginAdminstrador(String login) {
		if(login.equals(this.id)) {
			usuario.changeState(new Funcionario());
		}	
	}
}
