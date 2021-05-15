package com.projeto.vacinaja.model.estado;


import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.service.CidadaoService;

public class Habilitado2dose implements EstadoInterface{

	@Autowired
	CidadaoService cidadaoService;
	public void proximoEstado(Cidadao cidadao) {
		cidadao.alterarEstadoVacinacao(EstadoVacinacao.VACINACAO_FINALIZADA);	
		cidadaoService.salvarCidadao(cidadao);
	}
	
	@Override
	public String toString() {
		return "Habilitado para tomar 2ª dose da vacina";
	}
}
