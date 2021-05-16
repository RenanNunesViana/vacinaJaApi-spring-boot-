package com.projeto.vacinaja.controller;

import com.projeto.vacinaja.model.PerfilVacinacao;
import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.model.usuario.Funcionario;
import com.projeto.vacinaja.model.vacina.LoteVacina;
import com.projeto.vacinaja.model.vacina.Vacina;
import com.projeto.vacinaja.service.CidadaoService;
import com.projeto.vacinaja.service.FuncionarioService;
import com.projeto.vacinaja.service.LoteVacinaService;
import com.projeto.vacinaja.service.VacinaService;
import com.projeto.vacinaja.util.ErroCidadao;
import com.projeto.vacinaja.util.ErroFuncionario;
import com.projeto.vacinaja.util.ErroLoteVacina;
import com.projeto.vacinaja.util.ErroVacina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
			return ErroFuncionario.erroNenhumFuncionarioCadastrado();
		}
		return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
	}

	@RequestMapping(value = "/funcionario/", method = RequestMethod.POST)
	public ResponseEntity<?> cadastrarFuncionario(@RequestBody Funcionario novoFuncionario,
			UriComponentsBuilder uciBuilder) {
		Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(novoFuncionario.getCpf());
		if (!optionalCidadao.isPresent()) {
			return ErroCidadao.erroCidadaoNaoEncontrado();
		}
		funcionarioService.cadastrarFuncionario(novoFuncionario);
		return new ResponseEntity<String>("Funcionário Cadastradado", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarFuncionario(@PathVariable("id") String cpf) {
		Optional<Funcionario> optionalFuncionario = funcionarioService.retornaFuncionario(cpf);
		if (!optionalFuncionario.isPresent()) {
			return ErroFuncionario.erroFuncionarioNaoEncontrado();
		}
		return new ResponseEntity<Funcionario>(optionalFuncionario.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/funcionario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removerFuncionario(@PathVariable("id") String cpf) {
		Optional<Funcionario> optionalFuncionario = funcionarioService.retornaFuncionario(cpf);
		if (!optionalFuncionario.isPresent()) {
			return ErroFuncionario.erroFuncionarioNaoEncontrado();
		}
		funcionarioService.removerFuncionario(cpf);
		return new ResponseEntity<Funcionario>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/funcionario/cidadao", method = RequestMethod.PUT)
	public ResponseEntity<?> habilitarCidadaoParaVacinacao(@RequestBody PerfilVacinacao perfil) {
		int dosesDisponiveis = loteService.numeroTotalDoses();
		funcionarioService.habilitarCidadaoParaVacinacao(dosesDisponiveis, perfil);
		return new ResponseEntity<String>("Cidadão habilitado para a 1ª dose.", HttpStatus.OK);
	}

	@RequestMapping(value = "/funcionario/cidadao/carteira", method = RequestMethod.PUT)
	public ResponseEntity<?> registrarVacinacaoDeCidadao(@RequestBody String cpf, long loteVacina,String nomeVacina, int numeroDose) {

		Optional<Vacina> optionalVacina = vacinaService.consultarVacinaPorId(nomeVacina);
		Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(cpf);
		Optional<LoteVacina> optionalLote = loteService.consultarLotePorId(loteVacina);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAtual = new Date(System.currentTimeMillis());
		long diff = 0;
		try {
			Date validadeLote = data.parse(optionalLote.get().getDataDeValidade());
			diff = validadeLote.getTime() - dataAtual.getTime();
		}catch (ParseException e) {
			e.printStackTrace();
		}

		if (!optionalVacina.isPresent()) {
			return ErroVacina.erroVacinaNaoEncontrada(nomeVacina);
		}
		if (optionalVacina.get().getNumeroDoses() < numeroDose) {
			return ErroVacina.erroVacinaNaoPossuiDose(nomeVacina);
		}
		if (!optionalCidadao.isPresent()) {
			return ErroCidadao.erroCidadaoNaoEncontrado();
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
		if(diff < 0){
			return ErroLoteVacina.erroLoteVacinaForaDaValidade();
		}

		funcionarioService.registrarVacinacaoDeCidadao(cpf, String.valueOf(dataAtual), loteVacina, nomeVacina, numeroDose);
		cidadaoService.salvarCidadao(optionalCidadao.get()); // Novo. Verificar se está ok.
		return new ResponseEntity<String>("Vacinação registrada com sucesso", HttpStatus.OK);
	}

}
