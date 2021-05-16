package com.projeto.vacinaja.service;

import java.util.List;
import java.util.Optional;

import com.projeto.vacinaja.model.estado.EstadoVacinacao;
import com.projeto.vacinaja.model.usuario.Cidadao;

public interface CidadaoService {
	
    public void salvarCidadao(Cidadao cidadao);
    public void removerCidadao(String cpf);
    public List <Cidadao> listarCidadao();
    public Optional<Cidadao> pegarCidadao(String cpf);
    public EstadoVacinacao consultarEstagioVacinacao(String cpf);
}
