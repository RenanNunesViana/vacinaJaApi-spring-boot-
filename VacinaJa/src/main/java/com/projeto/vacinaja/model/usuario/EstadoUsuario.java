package com.projeto.vacinaja.model.usuario;

import java.util.ArrayList;

import com.projeto.vacinaja.model.comorbidades.Comorbidade;
import com.projeto.vacinaja.model.vacina.State;

public abstract class EstadoUsuario {
	
	Usuario usuario;
	
	EstadoUsuario(Usuario usuario) {
		this.usuario =  usuario;
	}
	
	public abstract void loginCidadao(String login);
	public abstract void loginFuncionario(String login);
	public abstract void loginAdminstrador(String login);
}
