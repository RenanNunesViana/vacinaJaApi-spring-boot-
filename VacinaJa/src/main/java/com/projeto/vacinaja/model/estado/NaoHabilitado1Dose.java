package com.projeto.vacinaja.model.estado;

import com.projeto.vacinaja.model.usuario.Cidadao;

public class NaoHabilitado1Dose extends EstadoVacinacao{

	public NaoHabilitado1Dose(Cidadao cidadao) {
		super(cidadao);
	}

	public void atualizar() {
	
	}
	
	public void tomarVacina() {
		
	}
	
	@Override
	public String toString() {
		return "Habilitado para tomar primeira dose da vacina";
	}
}
