package com.projeto.vacinaja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.model.usuario.Funcionario;
import com.projeto.vacinaja.model.vacina.Vacina;
import com.projeto.vacinaja.service.CidadaoService;
import com.projeto.vacinaja.service.FuncionarioService;
import com.projeto.vacinaja.util.CidadaoErro;
import com.projeto.vacinaja.util.FuncionarioErro;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FuncionarioApiController {

	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	CidadaoService cidadaoService;

	@RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
	public ResponseEntity<?> listarFuncionarios() {
		List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
		if (funcionarios.isEmpty()) {
			return FuncionarioErro.erroNenhumFuncionarioCadastrado();
		}
		return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
	}

	@RequestMapping(value = "/funcionario/", method = RequestMethod.POST)
	public ResponseEntity<?> cadastrarFuncionario(@RequestBody Funcionario novoFuncionario,
			UriComponentsBuilder uciBuilder) {
		Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(novoFuncionario.getCpf());
		if (!optionalCidadao.isPresent()) {
			return CidadaoErro.erroCidadaoNaoEncontrado();
		}
		funcionarioService.cadastrarFuncionario(novoFuncionario);
		return new ResponseEntity<String>("Funcionário Cadastradado", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarFuncionario(@PathVariable("id") Long id) {
		Optional<Funcionario> optionalFuncionario = funcionarioService.retornaFuncionarioPeloId(id);
		if (!optionalFuncionario.isPresent()) {
			return FuncionarioErro.erroFuncionarioNaoEncontrado();
		}
		return new ResponseEntity<Funcionario>(optionalFuncionario.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/funcionario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removerFuncionario(@PathVariable("id") Long id) {
		Optional<Funcionario> optionalFuncionario = funcionarioService.retornaFuncionarioPeloId(id);
		if (!optionalFuncionario.isPresent()) {
			return FuncionarioErro.erroFuncionarioNaoEncontrado();
		}
		funcionarioService.removerFuncionario(id);
		return new ResponseEntity<Funcionario>(HttpStatus.NO_CONTENT);
	}

}
