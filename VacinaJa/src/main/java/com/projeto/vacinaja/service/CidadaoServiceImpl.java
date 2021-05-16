package com.projeto.vacinaja.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.projeto.vacinaja.model.estado.EstadoVacinacao;
import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.repository.CidadaoRepository;

@Service
public class CidadaoServiceImpl implements CidadaoService{
	
	@Autowired
    private CidadaoRepository cidadaoRepository;

    @Override
    public void salvarCidadao(Cidadao cidadao) {
        this.cidadaoRepository.save(cidadao);
    }

    @Override
    public void removerCidadao(String cpf) {
    	Cidadao aux = this.cidadaoRepository.getOne(cpf);
        this.cidadaoRepository.delete(aux);
    }

    @Override
    public List<Cidadao> listarCidadao() {
        return this.cidadaoRepository.findAll();
    }

    @Override
    public Optional<Cidadao> pegarCidadao(String cpf) {
        return this.cidadaoRepository.findById(cpf);
    }

	@Override
	public EstadoVacinacao consultarEstagioVacinacao(String cpf) {
		Cidadao aux = this.cidadaoRepository.getOne(cpf);
		return aux.getEstadoVacinacao();
	}
	
}
