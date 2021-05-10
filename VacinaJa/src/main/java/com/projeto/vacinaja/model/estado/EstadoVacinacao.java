package com.projeto.vacinaja.model.estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.projeto.vacinaja.model.usuario.Cidadao;

@Entity
public abstract class EstadoVacinacao {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	Cidadao cidadao;

	public EstadoVacinacao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}
	
	public abstract void atualizar();
	public abstract void tomarVacina();
}
