package com.projeto.vacinaja.controller;

import com.projeto.vacinaja.model.Agendamento;
import com.projeto.vacinaja.model.estado.*;
import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.model.vacina.LoteVacina;
import com.projeto.vacinaja.model.vacina.Vacina;
import com.projeto.vacinaja.service.AgendamentoService;
import com.projeto.vacinaja.service.CidadaoService;
import com.projeto.vacinaja.service.LoteVacinaService;
import com.projeto.vacinaja.service.VacinaService;
import com.projeto.vacinaja.util.CidadaoErro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CidadaoApiController {

	@Autowired
    CidadaoService cidadaoService;

    @Autowired
    AgendamentoService agendamentoService;

    @Autowired
    LoteVacinaService loteVacinaService;

    @Autowired
    VacinaService vacinaService;

    @RequestMapping(value = "/cidadao/", method=RequestMethod.POST)
    public ResponseEntity<?> cadastrarCidadao(@RequestBody Cidadao cidadao, UriComponentsBuilder uciBuilder) {
        // WIP
        Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(cidadao.getCpf());
        if(optionalCidadao.isPresent()) {
            return CidadaoErro.erroCidadaoJaCadastrado();
        }
        cidadao.alterarEstadoVacinacao(new NaoHabilitado1Dose(cidadao));
        cidadaoService.salvarCidadao(cidadao);
        return new ResponseEntity<String>("Cidadão cadastrado", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/cidadao/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizarCadastro(@PathVariable("id")String cpf, @RequestBody Cidadao cidadao) {
        // WIP
        Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(cpf);
         if(!optionalCidadao.isPresent()) {
            return CidadaoErro.erroCidadaoNaoEncontrado();
        }
        Cidadao tempCidadao = optionalCidadao.get();
        tempCidadao.alteraNomeCompleto(cidadao.getNomeCompleto());
        tempCidadao.alteraEndereco(cidadao.getEndereco());
        tempCidadao.alteraEmail(cidadao.getEmail());
        tempCidadao.alteraTelefone(cidadao.getTelefone());
        tempCidadao.alteraProfissao(cidadao.getProfissao());
        
        cidadaoService.salvarCidadao(tempCidadao);
       return new ResponseEntity<String>("Dados atualizados com sucesso", HttpStatus.OK); 
    }
	
    @RequestMapping(value = "/cidadao/{id}/estadovacinacao", method= RequestMethod.GET)
    public ResponseEntity<?> checarEstadoVacinacao(@PathVariable("id")String cpf) {
        // WIP
        Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(cpf);
        if(!optionalCidadao.isPresent()) {
            return CidadaoErro.erroCidadaoNaoEncontrado();
        }
        return new ResponseEntity<String>(optionalCidadao.get().getEstadoVacinacao().toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/cidadao/{id}/agendamento", method = RequestMethod.PUT)
    public ResponseEntity<?> agendarVacinacao(@PathVariable("id")String cpf) {
        // WIP
        Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(cpf);
        if(!optionalCidadao.isPresent()) {
            return CidadaoErro.erroCidadaoNaoEncontrado();
        }
        Cidadao currentCidadao = optionalCidadao.get();
        Optional<Vacina> optionalVacina = vacinaService.consultarVacinaPorId(currentCidadao.getCarteriaVacinacao().getNomeVacina());
        Optional<LoteVacina> optionalLote = loteVacinaService.consultarLotePorVacina(optionalVacina.get());
        boolean habilitado = (currentCidadao.getEstadoVacinacao() instanceof Habilitado2dose) || (currentCidadao.getEstadoVacinacao() instanceof Habilitado1Dose);
        int dose = (currentCidadao.getEstadoVacinacao() instanceof Habilitado1Dose ? 1 : 2);
        if(optionalLote.get().getDoses() >= 0 && habilitado) {
            agendamentoService.cadastrarAgendamento(new Agendamento(cpf, dose, "05/05/2022-14:00"));
        }
        return new ResponseEntity<String>("Agendamento realizado com sucesso", HttpStatus.OK);
    }
}
