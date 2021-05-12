package com.projeto.vacinaja.model;

import java.util.Arrays;
import java.util.List;


public class VacinaRequerimentos {
	private final int IDADE_VACINACAO = 65;
    private final String PROFISSAO_VACINACAO = "Policial";

    String[] strArray = {"Diabetes", "Doença Renal Crônica", "Doença Cardíaca Crônica", "Doença Respiratória Crônica"};
    List<String> COMORBIDADE_VACINACAO = Arrays.asList(strArray);
    
    public int getIdadeDePrioridade() {
    	return this.IDADE_VACINACAO;
    }
    
    public String getProfissaoDePrioridade() {
    	return this.PROFISSAO_VACINACAO;
    }
    
    public List<String> getListaDeComorbidades() {
    	return this.COMORBIDADE_VACINACAO;
    }
}
