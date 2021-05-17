package com.projeto.vacinaja.model.estado;


import com.projeto.vacinaja.model.usuario.Cidadao;

public class FinalizadaVacinacao implements EstadoInterface{

	public void proximoEstado(Cidadao cidadao) {
		
	}

	@Override
	public String toString() {
		return "Vacinacao finalizada";
	}
	
	
}
