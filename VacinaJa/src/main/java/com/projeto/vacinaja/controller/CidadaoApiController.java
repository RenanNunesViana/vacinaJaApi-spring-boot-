package com.projeto.vacinaja.controller;

import com.projeto.vacinaja.model.Agendamento;
import com.projeto.vacinaja.model.estado.*;
import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.model.usuario.Role;
import com.projeto.vacinaja.model.vacina.LoteVacina;
import com.projeto.vacinaja.model.vacina.Vacina;
import com.projeto.vacinaja.repository.RoleRepository;
import com.projeto.vacinaja.service.AgendamentoService;
import com.projeto.vacinaja.service.CidadaoService;
import com.projeto.vacinaja.service.LoteVacinaService;
import com.projeto.vacinaja.service.VacinaService;
import com.projeto.vacinaja.util.ErroAgendamento;
import com.projeto.vacinaja.util.ErroCidadao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CidadaoApiController {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
    CidadaoService cidadaoService;

    @Autowired
    AgendamentoService agendamentoService;

    @Autowired
    LoteVacinaService loteVacinaService;

    @Autowired
    VacinaService vacinaService;
    
    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value = "/cidadao/", method=RequestMethod.POST)
    public ResponseEntity<?> cadastrarDadosCidadao(@RequestBody String cpf, String nome, String endereco, String email, String telefone, String dataDeNascimento,
                    String numeroSUS, String profissao, String userName, String password) {
        Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(cpf);
        if(optionalCidadao.isPresent()) {
            return ErroCidadao.erroCidadaoJaCadastrado();
        }
        Collection<Role> cidadaoRole = new HashSet<>();
        cidadaoRole.add(roleRepository.findByName("CIDADAO"));
        
        Cidadao novoCidadao = new Cidadao(nome, endereco, cpf, email, dataDeNascimento, telefone, numeroSUS, profissao, userName, passwordEncoder.encode(password), cidadaoRole);
        cidadaoService.salvarCidadao(novoCidadao);
        return new ResponseEntity<String>("Cidadão cadastrado", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/cidadao/{cpf}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizarCadastro(@PathVariable("cpf")String cpf, @RequestBody String nomeCompleto, String endereco, String email, String telefone, String profissao) {
        Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(cpf);
         if(!optionalCidadao.isPresent()) {
            return ErroCidadao.erroCidadaoNaoEncontrado();
        }
        Cidadao tempCidadao = optionalCidadao.get();
        tempCidadao.alteraNomeCompleto(nomeCompleto);
        tempCidadao.alteraEndereco(endereco);
        tempCidadao.alteraEmail(email);
        tempCidadao.alteraTelefone(telefone);
        tempCidadao.alteraProfissao(profissao);
        
        cidadaoService.salvarCidadao(tempCidadao);
       return new ResponseEntity<String>("Dados atualizados com sucesso", HttpStatus.OK); 
    }
	
    @RequestMapping(value = "/cidadao/{cpf}/estadovacinacao", method= RequestMethod.GET)
    public ResponseEntity<?> checarEstadoVacinacao(@PathVariable("cpf")String cpf) {
        Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(cpf);
        if(!optionalCidadao.isPresent()) {
            return ErroCidadao.erroCidadaoNaoEncontrado();
        }
        return new ResponseEntity<String>(optionalCidadao.get().getEstadoVacinacao().toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/cidadao/{cpf}/agendamento", method = RequestMethod.PUT)
    public ResponseEntity<?> agendarVacinacao(@PathVariable("cpf")String cpf) {
        Optional<Cidadao> optionalCidadao = cidadaoService.pegarCidadao(cpf);
        if(!optionalCidadao.isPresent()) {
            return ErroCidadao.erroCidadaoNaoEncontrado();
        }
        Cidadao currentCidadao = optionalCidadao.get();
        Optional<Vacina> optionalVacina = vacinaService.consultarVacinaPorId(currentCidadao.getCarteriaVacinacao().getNomeVacina());
        Optional<LoteVacina> optionalLote = loteVacinaService.consultarLotePorVacina(optionalVacina.get());
        boolean habilitado = (currentCidadao.getEstadoVacinacao() == EstadoVacinacao.HABILITADO_SEGUNDA_DOSE) || (currentCidadao.getEstadoVacinacao() == EstadoVacinacao.HABILITADO_PRIMEIRA_DOSE);
        int dose = (currentCidadao.getEstadoVacinacao() == EstadoVacinacao.HABILITADO_PRIMEIRA_DOSE ? 1 : 2);
        if(optionalLote.get().getDoses() >= 0 && habilitado) {
            agendamentoService.cadastrarAgendamento(new Agendamento(cpf, dose, "05/05/2022-14:00"));
        }
        return new ResponseEntity<String>("Agendamento realizado com sucesso", HttpStatus.OK);
    }

    @RequestMapping(value = "/cidado/{cpf}/agendamento", method = RequestMethod.GET)
    public ResponseEntity<?> checarAgendamento(@PathVariable("cpf")String cpf) {
        Optional<Cidadao> cidadao = cidadaoService.pegarCidadao(cpf);
        if(!cidadao.isPresent()){
            return ErroCidadao.erroCidadaoNaoEncontrado();
        }
        Optional<Agendamento> optionalAgendamento = agendamentoService.recuperarAgendamentoPorCpf(cpf);
        if(!optionalAgendamento.isPresent()){
            return ErroAgendamento.agendamentoNaoRealizado();
        }
        return new ResponseEntity<Agendamento>(optionalAgendamento.get(), HttpStatus.OK);
    }
}
