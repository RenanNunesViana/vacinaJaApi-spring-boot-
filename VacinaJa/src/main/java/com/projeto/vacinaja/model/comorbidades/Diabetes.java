package com.projeto.vacinaja.model.comorbidades;

public class Diabetes implements Comorbidade {
	@Override
	public String verificaComorbidade() {
		String output = "Você tem diabetes. Prioridade na Vacinação.";
		return output;
	}
}
