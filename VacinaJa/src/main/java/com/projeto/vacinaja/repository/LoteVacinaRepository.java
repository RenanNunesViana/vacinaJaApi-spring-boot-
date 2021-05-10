package com.projeto.vacinaja.repository;


import java.util.List;
import com.projeto.vacinaja.model.vacina.Vacina;
import com.projeto.vacinaja.model.vacina.LoteVacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoteVacinaRepository extends JpaRepository<LoteVacina, Long> {

	List<LoteVacina> findByVacina(Vacina vacina);
	
}
