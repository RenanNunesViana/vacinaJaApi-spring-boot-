package com.projeto.vacinaja.model.observers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.projeto.vacinaja.model.estado.EstadoVacinacao;
import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.service.CidadaoService;

@Component @EnableScheduling
public class VerificadorDeHabilitados {

	@Autowired
	CidadaoService cidadaoService;

	private static final String MEIO_DIA = "0 0 12 30 12 6";
	private static final String TIME_ZONE = "America/Sao_Paulo";
    
    @Scheduled(cron = MEIO_DIA, zone = TIME_ZONE)
    public void notificaHabilitados() {
        List<Cidadao> cidadaos = cidadaoService.listarCidadao();
        for(Cidadao cidadao: cidadaos) {
            if(cidadao.getEstadoVacinacao() == EstadoVacinacao.HABILITADO_PRIMEIRA_DOSE || cidadao.getEstadoVacinacao() == EstadoVacinacao.ESPERANDO_SEGUNDA_DOSE){
                cidadao.notificarHabilitado();
            }
        }
    }
}
