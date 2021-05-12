package com.projeto.vacinaja.model.estado;


import com.projeto.vacinaja.model.usuario.Cidadao;

public class Habilitado1Dose implements EstadoInterface{

	public void proximoEstado(Cidadao cidadao) {
		// WIP
		cidadao.alterarEstadoVacinacao(EstadoVacinacao.ESPERANDO_SEGUNDA_DOSE);
	}
	
	@Override
	public String toString() {
		return "apto para tomar primeira dose da vacina";
	}
}
