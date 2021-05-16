package com.projeto.vacinaja.controller;

import com.projeto.vacinaja.model.usuario.Funcionario;
import com.projeto.vacinaja.service.FuncionarioService;
import com.projeto.vacinaja.util.ErroFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AdmApiController {

	@Autowired
	FuncionarioService funcionarioService;

	@RequestMapping(value = "/funcionarios", method = RequestMethod.PUT)
	public ResponseEntity<?> aprovaCadastroFuncionario(@PathVariable String cpfFuncionario) {
		Optional<Funcionario> optionalFuncionario = funcionarioService.retornaFuncionario(cpfFuncionario);
		if(!optionalFuncionario.isPresent()) {
			return ErroFuncionario.erroFuncionarioNaoEncontrado();
		}
		if(optionalFuncionario.get().getAprovacao()) {
			return ErroFuncionario.erroFuncionarioJaAprovado();
		}
		funcionarioService.aprovaFuncionario(cpfFuncionario);
		return new ResponseEntity<Funcionario>((Funcionario) null, HttpStatus.ACCEPTED);
		
	}

}
