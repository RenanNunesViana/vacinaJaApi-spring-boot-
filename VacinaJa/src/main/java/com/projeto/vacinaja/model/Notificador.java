package com.projeto.vacinaja.model;

import java.util.ArrayList;
import java.util.List;

import com.projeto.vacinaja.model.usuario.Cidadao;

public class Notificador {
	private List<Notificavel> cidadaosNotificaveis;
	
	public Notificador() {
		this.cidadaosNotificaveis = new ArrayList<Notificavel>();
	}
	

	public void notificaCidadao(String cpfCidadao) {
		// adicionar contexto da notificacao?
//		cidadaosNotificaveis.get().notifica();
	}
	
	public void adicionaNotificavel(Cidadao cidadao) {
		this.cidadaosNotificaveis.add((Notificavel) cidadao);
	}

	public void removeNotificavel(Notificavel notificavel) {
		this.cidadaosNotificaveis.remove(notificavel);
	}
}
