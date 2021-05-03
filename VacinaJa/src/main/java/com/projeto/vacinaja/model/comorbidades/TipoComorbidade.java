package com.projeto.vacinaja.model.comorbidades;

public enum TipoComorbidade {
	 ObesidadeMorbida {
		@Override
		public Comorbidade getComorbidade() {
			return new ObesidadeMorbida();
		}
	 },
	 Diabetes {
		@Override
		public Comorbidade getComorbidade() {
			return new Diabetes();
		}
	 },
	 InsuficiencaCardiaca {
		@Override
		public Comorbidade getComorbidade() {
			return new InsuficienciaCardiaca();
		}
	 },
	 SindromeDeDown {
		@Override
		public Comorbidade getComorbidade() {
			return new SindromeDown();
		}
	 },
	 DoençaCardiovascularCronica {
		@Override
		public Comorbidade getComorbidade() {
			return new DoençaCardiovascularCronica();
		}
	 },
	 DoencaRenalCronica {
		@Override
		public Comorbidade getComorbidade() {
			return new DoençaCardiovascularCronica();
		}
	 };
	
	public abstract Comorbidade getComorbidade();
}
