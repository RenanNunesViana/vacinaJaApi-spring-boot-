package com.projeto.vacinaja.controller;

import com.projeto.vacinaja.model.vacina.LoteVacina;
import com.projeto.vacinaja.model.vacina.Vacina;
import com.projeto.vacinaja.service.LoteVacinaService;
import com.projeto.vacinaja.service.VacinaService;

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

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoteVacinaApiController {

	@Autowired
	VacinaService vacinaService;

	@Autowired
	LoteVacinaService loteVacinaService;

	@RequestMapping(value = "/lotes", method = RequestMethod.GET)
	public ResponseEntity<?> listarLotes() {
		List<LoteVacina> lotes = loteVacinaService.listarLotesVacinas();
		// if(lotes.isEmpty())
		// return ErroLote.semLotesCadastrados();
		return new ResponseEntity<List<LoteVacina>>(lotes, HttpStatus.OK);
	}

	@RequestMapping(value = "/vacina/{id}/lote", method = RequestMethod.POST)
	public ResponseEntity<?> cadastraLote(@PathVariable("id") String id, @RequestBody int numeroDoses,
			String dataDeValidade) {
		Optional<Vacina> optionalVacina = vacinaService.consultarVacinaPorId(id);
		// if(!optionalVacina.isPresent())
		// return ErroVacina.vacinaNaoCadastrada();
		LoteVacina novoLote = new LoteVacina(optionalVacina.get(), numeroDoses, dataDeValidade);
		loteVacinaService.salvarLoteVacina(novoLote);
		return new ResponseEntity<LoteVacina>(novoLote, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/vacina/{id}/lote", method = RequestMethod.GET)
	public ResponseEntity<?> consultarLotePorVacina(@PathVariable String id) {
		Optional<Vacina> optionalVacina = vacinaService.consultarVacinaPorId(id);
		// if(!optionalVacina.isPresent())
		// return ErroVacina.vacinaNaoCadastrada();
		Optional<LoteVacina> optionalLote = loteVacinaService.consultarLotePorVacina(optionalVacina.get());
		// if(lotes.isEmpty())
		// return ErroLote.loteVazio();
		return new ResponseEntity<LoteVacina>(optionalLote.get(), HttpStatus.OK);
	}
}
