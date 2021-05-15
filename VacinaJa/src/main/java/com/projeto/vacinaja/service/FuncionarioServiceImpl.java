package com.projeto.vacinaja.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.vacinaja.model.PerfilVacinacao;
import com.projeto.vacinaja.model.estado.EstadoVacinacao;
import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.model.usuario.Funcionario;
import com.projeto.vacinaja.model.vacina.LoteVacina;
import com.projeto.vacinaja.repository.CidadaoRepository;
import com.projeto.vacinaja.repository.FuncionarioRepository;
import com.projeto.vacinaja.repository.LoteVacinaRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private CidadaoRepository cidadaoRepository;
	@Autowired
	private LoteVacinaRepository loteRepository;

	@Override
	public void cadastrarFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		
	}

	@Override
	public List<Funcionario> listarFuncionarios() {
		return funcionarioRepository.findAll();
	}

	@Override
	public Optional<Funcionario> retornaFuncionario(String cpf) {
		return funcionarioRepository.findById(cpf);
	}

	@Override
	public void removerFuncionario(String cpf) {
		Funcionario aux = this.funcionarioRepository.getOne(cpf);
		this.funcionarioRepository.delete(aux);
	}

	@Override
	public void habilitarCidadaoParaVacinacao(int dosesDisponiveis, PerfilVacinacao perfil) {

		List<Cidadao> cidadaos = this.cidadaoRepository.findAll();
		List<String> comorbidades = perfil.getListaDeComorbidades();
		List<String> profissoes = perfil.getProfissaoDePrioridade();

		int cont = 0;
		while (dosesDisponiveis > 0 && cidadaos.size() >= cont) {
			Cidadao c = cidadaos.get(cont);
			if (comorbidades.contains(c.getComorbidade()) || profissoes.contains(c.getProfissao())
					|| perfil.getIdadeDePrioridade() <= c.getIdade()) {

				if (c.getEstadoVacinacao() == EstadoVacinacao.NAO_HABILITADO) {
					c.notifica();
					dosesDisponiveis--;
				}
			}
			cont++;
		}
	}

	@Override
	public void registrarVacinacaoDeCidadao(String cpf, String dataVacinacao, long loteVacina, String nomeVacina,
			int numeroDose) {
		Cidadao c = cidadaoRepository.getOne(cpf);
		LoteVacina lv = loteRepository.getOne(loteVacina);

		if (numeroDose == 1) {
			c.getCarteriaVacinacao().setData1Dose(dataVacinacao);
		} else if (numeroDose == 2) {
			c.getCarteriaVacinacao().setData2Dose(dataVacinacao);
		}
		c.getCarteriaVacinacao().setNumeroDaDose(numeroDose);
		c.getCarteriaVacinacao().setNomeVacina(nomeVacina);
		c.getCarteriaVacinacao().setLoteVacina(loteVacina);
		c.notifica();
		lv.setDoses(lv.getDoses() - 1);
	}

	@Override
	public void aprovaFuncionario(String cpf) {
		 funcionarioRepository.getOne(cpf).setAprovacao(true);
		
	}
}
