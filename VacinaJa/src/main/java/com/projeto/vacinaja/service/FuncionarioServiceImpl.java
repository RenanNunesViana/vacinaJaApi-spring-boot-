package com.projeto.vacinaja.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.model.usuario.Funcionario;
import com.projeto.vacinaja.model.vacina.Vacina;
import com.projeto.vacinaja.repository.CidadaoRepository;
import com.projeto.vacinaja.repository.FuncionarioRepository;

public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private CidadaoRepository cidadaoRepository;

	@Override
	public void cadastrarFuncionario(Funcionario funcionario) {
		//if (cidadaoRepository.findByCpf(funcionario.getCpf()) != null) {
			funcionarioRepository.save(funcionario);
		//}

	}

	@Override
	public List<Funcionario> listarFuncionarios() {
		return funcionarioRepository.findAll();
	}

	@Override
	public Optional<Funcionario> retornaFuncionarioPeloId(Long id) {
		return funcionarioRepository.findById(id);
	}

	@Override
	public void removerFuncionario(Long id) {
		Funcionario aux = this.funcionarioRepository.getOne(id);
		this.funcionarioRepository.delete(aux);
	}

	@Override
	public void habilitarCidadaoParaVacinacao(ArrayList<Cidadao> listaCidadaos, int dosesDisponiveis, String perfil) {
		
	}

	@Override
	public void registrarVacinacaoDeCidadao(String cpf, String dataVacinacao, int loteVacina, Vacina tipo,
			int numeroDose) {

	}

}
