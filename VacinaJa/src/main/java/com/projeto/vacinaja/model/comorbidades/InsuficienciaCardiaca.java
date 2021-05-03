package com.projeto.vacinaja.model.comorbidades;

public class InsuficienciaCardiaca implements Comorbidade {
	@Override
	public String verificaComorbidade() {
		String output = "Você tem insuficiência cardíaca. Prioridade na Vacinação.";
		return output;
	}
}
