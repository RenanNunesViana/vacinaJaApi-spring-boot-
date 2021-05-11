package com.projeto.vacinaja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.vacinaja.model.usuario.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	Optional<Funcionario> findByCpf(String cpf);
}
