package com.projeto.vacinaja.model.estado;


import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.service.CidadaoService;

public class Habilitado1Dose implements EstadoInterface{
	
	@Autowired
	CidadaoService cidadaoService;
	public void proximoEstado(Cidadao cidadao) {
		cidadao.alterarEstadoVacinacao(EstadoVacinacao.ESPERANDO_SEGUNDA_DOSE);
		cidadaoService.salvarCidadao(cidadao);
	}
	
	@Override
	public String toString() {
		return "apto para tomar primeira dose da vacina";
	}
}
