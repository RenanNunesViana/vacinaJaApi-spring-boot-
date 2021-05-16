package com.projeto.vacinaja.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.projeto.vacinaja.model.estado.EstadoVacinacao;
import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.model.vacina.Vacina;
import com.projeto.vacinaja.service.CidadaoService;
import com.projeto.vacinaja.service.VacinaService;

@Component @EnableScheduling
public class VerificadorParaSegundaDose {
	
	@Autowired
	CidadaoService cidadaoService;

	@Autowired
	VacinaService vacinaService;
	
	private static final String MEIO_DIA = "0 0 12 30 12 6";
	private static final String TIME_ZONE = "America/Sao_Paulo";

	@Scheduled(cron = MEIO_DIA, zone = TIME_ZONE)
	public void verificaPorDia() {
		List<Cidadao> cidadaos = cidadaoService.listarCidadao();
		for(Cidadao cidadao: cidadaos) {
			if(cidadao.getEstadoVacinacao() == EstadoVacinacao.ESPERANDO_SEGUNDA_DOSE) {
				String nomeVacina = cidadao.getCarteriaVacinacao().getNomeVacina();	
				Vacina vacina = vacinaService.consultarVacinaPorId(nomeVacina).get();
				if(verificaDiferencaDias(cidadao.getCarteriaVacinacao().getData1Dose(), vacina.getDiasEntreDoses())){
					cidadao.notifica();
				}
			}
		}
	}

	private static boolean verificaDiferencaDias(String dataVacinacao, int diaEntreDoses) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int diasDiferenca = -1;
		try {
			Date data1 = sdf.parse(dataVacinacao);
			Date data2 = new Date(System.currentTimeMillis());

			long diff = data2.getTime() - data1.getTime();
			diasDiferenca = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
		}
		return diasDiferenca >= diaEntreDoses;
	}
	
}
