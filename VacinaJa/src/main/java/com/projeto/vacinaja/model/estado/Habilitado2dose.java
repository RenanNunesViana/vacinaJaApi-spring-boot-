package com.projeto.vacinaja.model.estado;

import com.projeto.vacinaja.model.usuario.Cidadao;

public class Habilitado2dose extends EstadoVacinacao{

	public Habilitado2dose(Cidadao cidadao) {
		super(cidadao);
	}

	public void atualizar() {
		this.cidadao.alterarEstadoVacinacao(new FinalizadaVacinacao(this.cidadao));	
	}
	
	public void tomarVacina() {
		
	}
	
	@Override
	public String toString() {
		return "Habilitado para tomar 2ª dose da vacina";
	}
}
