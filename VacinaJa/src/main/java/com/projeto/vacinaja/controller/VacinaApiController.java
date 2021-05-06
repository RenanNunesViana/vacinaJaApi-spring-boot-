package com.projeto.vacinaja.controller;

import com.projeto.vacinaja.model.vacina.Vacina;
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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VacinaApiController {
    @Autowired
    VacinaService vacinaService;

    @RequestMapping(value = "/vacinas", method=RequestMethod.GET)
    public ResponseEntity<?> listarVacinas() {
        List<Vacina> vacinas = vacinaService.listarVacinas();
        // if(vacinas.isEmpty())
            // return ErroVacina.semVacinasCadastradas();
        return new ResponseEntity<List<Vacina>>(vacinas, HttpStatus.OK);
    }

    @RequestMapping(value = "/vacina/", method=RequestMethod.POST)
    public ResponseEntity<?> cadastrarVacina(@RequestBody Vacina novaVacina, UriComponentsBuilder uciBuilder) {
        Optional<Vacina> optionalVacina = vacinaService.consultarVacinaPorId(novaVacina.getNomeVacina());
        // if(optionalVacina.isPresent()) 
            // return ErroVacina.vacinaJaCadastrada();
        vacinaService.salvarVacina(novaVacina);
        return new ResponseEntity<String>("Vacina Cadastradada", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/vacina/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> consultarVacina(@PathVariable("id") String id) {
        Optional<Vacina> optionalVacina = vacinaService.consultarVacinaPorId(id);
        // if(!optionalVacina.isPresent())
            // return ErroVacina.vacinaNaoCadastrada();
        return new ResponseEntity<Vacina>(optionalVacina.get(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/vacina/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> removerVacina(@PathVariable("id") String id) {
        Optional<Vacina> optionalVacina = vacinaService.consultarVacinaPorId(id);
        if(!optionalVacina.isPresent())
            // return ErroVacina.vacinaNaoCadastrada();
        vacinaService.removerVacina(id);
        return new ResponseEntity<Vacina>(HttpStatus.NO_CONTENT);
    }
}
