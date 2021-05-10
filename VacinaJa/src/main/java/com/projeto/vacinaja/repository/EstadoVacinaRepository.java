package com.projeto.vacinaja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.vacinaja.model.estado.EstadoVacinacao;

public interface EstadoVacinaRepository extends JpaRepository<EstadoVacinacao, Long>{

}
