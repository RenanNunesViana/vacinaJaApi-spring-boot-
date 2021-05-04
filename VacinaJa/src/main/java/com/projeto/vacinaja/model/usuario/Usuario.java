package com.projeto.vacinaja.model.usuario;

public class Usuario {
	
	public String nome;
	public String cpf;
	private EstadoUsuario estado;
	
	public void changeState(EstadoUsuario estado) {
		this.estado = estado;
	}
}
