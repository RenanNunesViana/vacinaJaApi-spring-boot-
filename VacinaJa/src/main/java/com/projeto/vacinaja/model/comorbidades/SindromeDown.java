package com.projeto.vacinaja.model.comorbidades;

public class SindromeDown implements Comorbidade {
	@Override
	public String verificaComorbidade() {
		String output = "Você tem síndrome de Down. Prioridade na Vacinação.";
		return output;
	}
}
