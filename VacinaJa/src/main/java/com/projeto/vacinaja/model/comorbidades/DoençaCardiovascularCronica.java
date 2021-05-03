package com.projeto.vacinaja.model.comorbidades;

public class DoençaCardiovascularCronica implements Comorbidade {
	@Override
	public String verificaComorbidade() {
		String output = "Você tem doença cardiovascular crônica. Prioridade na Vacinação.";
		return output;
	}
}
