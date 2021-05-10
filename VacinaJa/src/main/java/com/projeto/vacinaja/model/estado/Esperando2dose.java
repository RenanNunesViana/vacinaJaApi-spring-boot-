package com.projeto.vacinaja.model.estado;

import com.projeto.vacinaja.model.usuario.Cidadao;

public class Esperando2dose extends EstadoVacinacao{

	public Esperando2dose(Cidadao cidadao) {
		super(cidadao);
	}

	public void atualizar() {
		
	}
	
	public void tomarVacina() {
		
	}
	
	@Override
	public String toString() {
		return "1ª dose tomada, esperando para poder tomar 2ª dose";
	}
}
