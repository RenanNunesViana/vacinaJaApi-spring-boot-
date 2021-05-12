package com.projeto.vacinaja.model.estado;

import com.projeto.vacinaja.model.usuario.Cidadao;

public class Habilitado1Dose extends EstadoVacinacao{

	public Habilitado1Dose(Cidadao cidadao) {
		super(cidadao);
	}

	public void atualizar() {
		// WIP
		this.cidadao.alterarEstadoVacinacao(new Esperando2dose(this.cidadao));
	}
	
	@Override
	public String toString() {
		return "apto para tomar primeira dose da vacina";
	}
}
