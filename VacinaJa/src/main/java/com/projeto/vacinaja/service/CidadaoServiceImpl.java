package com.projeto.vacinaja.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.projeto.vacinaja.model.estado.EstadoVacinacao;
import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.repository.CidadaoRepository;

public class CidadaoServiceImpl implements CidadaoService{
	
	@Autowired
    private CidadaoRepository cidadaoRepository;

    @Override
    public void salvarCidadao(Cidadao cidadao) {
        this.cidadaoRepository.save(cidadao);
    }

    @Override
    public void removerCidadao(String cpf) {
    	Optional<Cidadao> aux = this.cidadaoRepository.findByCpf(cpf);
        this.cidadaoRepository.delete(aux.get());
    }

    @Override
    public List<Cidadao> listarCidadao() {
        return this.cidadaoRepository.findAll();
    }

    @Override
    public Optional<Cidadao> pegarCidadao(String cpf) {
        return this.cidadaoRepository.findByCpf(cpf);
    }

	@Override
	public EstadoVacinacao consultarEstagioVacinacao(String cpf) {
		Optional<Cidadao> aux = this.cidadaoRepository.findByCpf(cpf);
		return aux.get().getEstadoVacinacao();
	}

	@Override
	public String agendarVacinacao(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
}
