package com.projeto.vacinaja.model.estado;

import com.projeto.vacinaja.model.usuario.Cidadao;

public class FinalizadaVacinacao extends EstadoVacinacao{

	public FinalizadaVacinacao(Cidadao cidadao) {
		super(cidadao);
	}

	public void atualizar() {
		
	}

	@Override
	public String toString() {
		return "Vacinacao finalizada";
	}
	
	
}
