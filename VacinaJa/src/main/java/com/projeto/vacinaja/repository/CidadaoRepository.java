package com.projeto.vacinaja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.vacinaja.model.usuario.Cidadao;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {
	
	Optional<Cidadao> findByCpf(String cpf);
}








