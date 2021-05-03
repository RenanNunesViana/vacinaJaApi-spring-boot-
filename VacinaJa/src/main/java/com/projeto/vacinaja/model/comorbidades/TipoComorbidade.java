package com.projeto.vacinaja.model.comorbidades;

public enum TipoComorbidade {
	 ObesidadeMorbida {
		@Override
		public String getComorbidade() {
			return "Obesidade Mórbida";
		}
	 },
	 Diabetes {
		@Override
		public String getComorbidade() {
			return "Diabetes";
		}
	 },
	 InsuficiencaCardiaca {
		@Override
		public String getComorbidade() {
			return "Insuficiência Cardíaca";
		}
	 },
	 SindromeDeDown {
		@Override
		public String getComorbidade() {
			return "Síndrome de Down";
		}
	 },
	 DoençaCardiovascularCronica {
		@Override
		public String getComorbidade() {
			return "Doença Cardiovascular Crônica";
		}
	 },
	 DoencaRenalCronica {
		@Override
		public String getComorbidade() {
			return "Doença Renal Crônica";
		}
	 };
	
	public abstract String getComorbidade();
}
