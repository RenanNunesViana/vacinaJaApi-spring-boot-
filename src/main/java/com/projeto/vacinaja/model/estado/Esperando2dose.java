package com.projeto.vacinaja.model.estado;


import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.service.CidadaoService;

public class Esperando2dose implements EstadoInterface{

	@Autowired
	CidadaoService cidadaoService;
	public void proximoEstado(Cidadao cidadao) {
		cidadao.alterarEstadoVacinacao(EstadoVacinacao.HABILITADO_SEGUNDA_DOSE);
		cidadaoService.salvarCidadao(cidadao);
	}
	
	@Override
	public String toString() {
		return "1ª dose tomada, esperando para poder tomar 2ª dose";
	}
}
