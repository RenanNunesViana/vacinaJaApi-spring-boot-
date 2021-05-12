package com.projeto.vacinaja.model.estado;


import com.projeto.vacinaja.model.usuario.Cidadao;

public class Habilitado2dose implements EstadoInterface{

	public void proximoEstado(Cidadao cidadao) {
		// WIP
		cidadao.alterarEstadoVacinacao(EstadoVacinacao.VACINACAO_FINALIZADA);	
	}
	
	@Override
	public String toString() {
		return "Habilitado para tomar 2ª dose da vacina";
	}
}
