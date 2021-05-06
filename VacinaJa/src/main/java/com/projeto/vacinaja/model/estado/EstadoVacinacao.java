package com.projeto.vacinaja.model.estado;

import com.projeto.vacinaja.model.usuario.Cidadao;

public abstract class EstadoVacinacao {

	Cidadao cidadao;

	public EstadoVacinacao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}
	
	public abstract void atualizar();
	public abstract void tomarVacina();
}
