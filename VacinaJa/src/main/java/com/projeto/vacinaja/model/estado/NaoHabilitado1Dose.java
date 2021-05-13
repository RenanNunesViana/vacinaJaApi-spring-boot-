package com.projeto.vacinaja.model.estado;

import com.projeto.vacinaja.model.usuario.Cidadao;

public class NaoHabilitado1Dose implements EstadoInterface{

	public void proximoEstado(Cidadao cidadao) {
		// WIP
		String dataDeNascimento = cidadao.getDataNascimento();
		String comorbidade = cidadao.getComorbidade();
		String profissao = cidadao.getProfissao();
//		RequerimentosPrimeiraDose rpd = new RequerimentosPrimeiraDose();	
		// if(rpd.checaRequerimentos(dataDeNascimento, comorbidade, profissao))
			//this.cidadao.alterarEstadoVacinacao(new Habilitado1Dose(this.cidadao));
	}
	
	@Override
	public String toString() {
		return "Habilitado para tomar primeira dose da vacina";
	}

}
