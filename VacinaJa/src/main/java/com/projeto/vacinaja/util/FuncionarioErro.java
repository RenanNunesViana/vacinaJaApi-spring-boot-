package com.projeto.vacinaja.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FuncionarioErro {
	
	static final String FUNCIONARIO_JA_CADASTRADO = "O funcionário já foi cadastrado";

	static final String NENHUM_FUNCIONARIO_CADASTRADO =  "Até o momento, nenhum funcionário foi cadastrado";

	static final String FUNCIONARIO_NAO_ENCONTRADO =  "O funcionário ainda não foi cadastrado";

	public static ResponseEntity<CustomErrorType> erroFuncionarioJaCadastrado() {
		return new ResponseEntity<CustomErrorType>(
				new CustomErrorType(FuncionarioErro.FUNCIONARIO_JA_CADASTRADO),
				HttpStatus.CONFLICT);
	}
	
	public static ResponseEntity<CustomErrorType> erroNenhumFuncionarioCadastrado() {
		return new ResponseEntity<CustomErrorType>(
				new CustomErrorType(FuncionarioErro.NENHUM_FUNCIONARIO_CADASTRADO),
				HttpStatus.NOT_FOUND);
	}
	
	public static ResponseEntity<CustomErrorType> erroFuncionarioNaoEncontrado() {
		return new ResponseEntity<CustomErrorType>(
				new CustomErrorType(FuncionarioErro.FUNCIONARIO_NAO_ENCONTRADO),
				HttpStatus.NOT_FOUND);
	}


}
