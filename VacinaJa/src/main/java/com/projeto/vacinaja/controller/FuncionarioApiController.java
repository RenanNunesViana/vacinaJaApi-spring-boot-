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

import com.projeto.vacinaja.model.PerfilVacinacao;
import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.model.usuario.Funcionario;
import com.projeto.vacinaja.model.vacina.LoteVacina;
import com.projeto.vacinaja.model.vacina.Vacina;
import com.projeto.vacinaja.service.CidadaoService;
import com.projeto.vacinaja.service.FuncionarioService;
import com.projeto.vacinaja.service.LoteVacinaService;
import com.projeto.vacinaja.service.VacinaService;
import com.projeto.vacinaja.util.CidadaoErro;
import com.projeto.vacinaja.util.ErroLoteVacina;
import com.projeto.vacinaja.util.ErroVacina;
import com.projeto.vacinaja.util.FuncionarioErro;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FuncionarioApiController {

	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	CidadaoService cidadaoService;

	@Autowired
	VacinaService vacinaService;
	
	@Autowired
	LoteVacinaService loteService;

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
	public ResponseEntity<?> consultarFuncionario(@PathVariable("id") String cpf) {
		Optional<Funcionario> optionalFuncionario = funcionarioService.retornaFuncionario(cpf);
		if (!optionalFuncionario.isPresent()) {
			return FuncionarioErro.erroFuncionarioNaoEncontrado();
		}
		return new ResponseEntity<Funcionario>(optionalFuncionario.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/funcionario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removerFuncionario(@PathVariable("id") String cpf) {
		Optional<Funcionario> optionalFuncionario = funcionarioService.retornaFuncionario(cpf);
		if (!optionalFuncionario.isPresent()) {
			return FuncionarioErro.erroFuncionarioNaoEncontrado();
		}
		funcionarioService.removerFuncionario(cpf);
		return new ResponseEntity<Funcionario>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/funcionario/", method = RequestMethod.PUT)
	public ResponseEntity<?> habilitarCidadaoParaVacinacao(@RequestBody int dosesDisponiveis, PerfilVacinacao perfil,
			int numeroDaDose) {
		funcionarioService.habilitarCidadaoParaVacinacao(dosesDisponiveis, perfil, numeroDaDose);
		return new ResponseEntity<String>("Cidadão habilitado para vacinação", HttpStatus.OK);
	}

	@RequestMapping(value = "/funcionario/", method = RequestMethod.PUT)
	public ResponseEntity<?> registrarVacinacaoDeCidadao(@RequestBody String cpf, String dataVacinacao, long loteVacina,
			String nomeVacina, int numeroDose) {
		Optional<Vacina> optionalVacina = vacinaService.consultarVacinaPorId(nomeVacina);
		Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(cpf);
		Optional<LoteVacina> optionalLote = loteService.consultarLotePorId(loteVacina);
		if (!optionalVacina.isPresent()) {
			return ErroVacina.erroVacinaNaoEncontrada(nomeVacina);
		}
		if (optionalVacina.get().getNumeroDoses() < numeroDose) {
			return ErroVacina.erroVacinaNaoPossuiDose(nomeVacina);
		}
		if (!optionalCidadao.isPresent()) {
			return CidadaoErro.erroCidadaoNaoEncontrado();
		}
		if(!optionalLote.isPresent()) {
			return ErroLoteVacina.erroLoteVacinaNaoCadastrada(loteVacina);
		}
		if(!optionalLote.get().getVacina().getNomeVacina().equals(nomeVacina)) {
			return ErroLoteVacina.erroLoteVacinaErrada(loteVacina, nomeVacina);
		}
		if(optionalLote.get().getDoses() == 0) {
			return ErroLoteVacina.erroLoteVacinaSemDoses();
		}
		/*if(checa se esta habiltiado para tomar a 1 dose e numero dose != 1)
		 * if(checa se esta habiltiado para tomar a 2 dose e numero dose != 2)
		 * 
		 */
		
		funcionarioService.registrarVacinacaoDeCidadao(cpf, dataVacinacao, loteVacina, nomeVacina, numeroDose);
		return new ResponseEntity<String>("Vacinação registrada com sucesso", HttpStatus.OK);
	}

}
