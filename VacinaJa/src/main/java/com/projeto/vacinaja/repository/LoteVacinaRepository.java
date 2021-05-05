package com.projeto.vacinaja.repository;


import com.projeto.vacinaja.model.vacina.LoteVacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoteVacinaRepository extends JpaRepository<LoteVacina, Long> {
}
