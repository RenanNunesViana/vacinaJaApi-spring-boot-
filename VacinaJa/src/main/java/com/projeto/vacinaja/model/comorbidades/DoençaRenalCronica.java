package com.projeto.vacinaja.model.comorbidades;

public class DoençaRenalCronica implements Comorbidade{
	@Override
	public String verificaComorbidade() {
		String output = "Você tem doença renal crônica. Prioridade na Vacinação.";
		return output;
	}
}
