package com.projeto.vacinaja.service;

import com.projeto.vacinaja.model.vacina.LoteVacina;

import java.util.List;
import java.util.Optional;

public interface LoteVacinaService {

    public void salvarLoteVacina(LoteVacina loteVacina);
    public void removerLoteVacina(long idLoteVacina);
    public Optional<LoteVacina> pegarLoteVacina(long idLoteVacina);
    public List <LoteVacina> listarLotesVacinas();

}
