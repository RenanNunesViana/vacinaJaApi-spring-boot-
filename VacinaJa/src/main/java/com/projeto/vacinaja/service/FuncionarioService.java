package com.projeto.vacinaja.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.model.usuario.Funcionario;
import com.projeto.vacinaja.model.vacina.Vacina;

public interface FuncionarioService {

	public void cadastrarFuncionario(Funcionario funcionario);

	public List<Funcionario> listarFuncionarios();

	public Optional<Funcionario> retornaFuncionarioPeloId(Long id);

	public void removerFuncionario(Long id);

	public void habilitarCidadaoParaVacinacao(ArrayList<Cidadao> listaCidadaos, int dosesDisponiveis, String perfil);

	public void registrarVacinacaoDeCidadao(String cpf, String dataVacinacao, int loteVacina, Vacina tipo,
			int numeroDose);

}
