package com.projeto.vacinaja.service;

import com.projeto.vacinaja.model.vacina.LoteVacina;
import com.projeto.vacinaja.model.vacina.Vacina;

import java.util.List;

public interface LoteVacinaService {

    public void salvarLoteVacina(LoteVacina loteVacina);
    public void removerLoteVacina(long idLoteVacina);
    public List <LoteVacina> consultarLotePorVacina(Vacina vacina);
    public List <LoteVacina> listarLotesVacinas();

}
