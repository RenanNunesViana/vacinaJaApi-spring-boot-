package com.projeto.vacinaja.model.estado;

import com.projeto.vacinaja.model.usuario.Cidadao;

public class NaoHabilitado1Dose extends EstadoVacinacao{

	public NaoHabilitado1Dose(Cidadao cidadao) {
		super(cidadao);
	}

	public void atualizar() {
		// WIP
		String dataDeNascimento = this.cidadao.getDataNascimento();
		String comorbidade = this.cidadao.getComorbidade();
		String profissao = this.cidadao.getProfissao();
		// RequerimentosPrimeiraDose rpd = new RequerimentosPrimeiraDose();	
		// if(rpd.checaRequerimentos(dataDeNascimento, comorbidade, profissao))
			//this.cidadao.alterarEstadoVacinacao(new Habilitado1Dose(this.cidadao));
	}
	
	@Override
	public String toString() {
		return "Habilitado para tomar primeira dose da vacina";
	}

	@Override
	public void tomarVacina() {
		// TODO Auto-generated method stub
		
	}
}
