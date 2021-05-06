package com.projeto.vacinaja.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FuncionarioApiController {

    // @Autowired
    // FuncionarioService funcionarioService;
    // @Autowired
    // CidadaoService cidadaoService;
    // @Autowired
    // LoteVacinaService loteVacinaService;

    // Notificador notificador = new Notificador();

    @RequestMapping(value="/funcionario/registrarVacina", method=RequestMethod.PUT)
    public ResponseEntity<?> registrarVacinacaoDeCidadao(@RequestBody String cpf, String data, int loteVacina, String nomeVacina, int numeroDaDose) {
        // Optional<Cidadao> optionalCidadao = cidadaoService.consultarCidadaoPorCpf(cpf);
        // Optional<Lote> optionalLote = loteVacinaService.consultarLotePorId(loteVacina);
        // notificador.noficar(cpf);
        // atualiza dados cidadao
        // atualiza lote vacina
        // retorna resposta ao servidor
    	return null;
    }

    @RequestMapping(value = "/funcionario/habilitarVacina", method=RequestMethod.PUT)
    public ResponseEntity<?> habilitarVacinacao(@RequestBody int idadeMinima, String profissao, String comorbidade) {
        // noficador.notificaTodos(idadeMinima, profissao, comorbidade);
        // return new ResponseEntity<>();
    	return null;
    }

}
