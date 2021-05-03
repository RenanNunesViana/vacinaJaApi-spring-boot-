package com.projeto.vacinaja.model.comorbidades;

public class ObesidadeMorbida implements Comorbidade {
	@Override
	public String verificaComorbidade() {
		String output = "Você tem obesidade morbida. Prioridade na Vacinação.";
		return output;
	}
}
