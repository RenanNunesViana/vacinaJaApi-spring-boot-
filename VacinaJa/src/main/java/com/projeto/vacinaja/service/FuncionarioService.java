package com.projeto.vacinaja.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.projeto.vacinaja.model.PerfilVacinacao;
import com.projeto.vacinaja.model.usuario.Cidadao;
import com.projeto.vacinaja.model.usuario.Funcionario;
import com.projeto.vacinaja.model.vacina.Vacina;

public interface FuncionarioService {

	public void cadastrarFuncionario(Funcionario funcionario);

	public List<Funcionario> listarFuncionarios();

	public Optional<Funcionario> retornaFuncionario(String cpf);

	public void removerFuncionario(String cpf);

	public void registrarVacinacaoDeCidadao(String cpf, String dataVacinacao, long loteVacina, String nomeVacina,
			int numeroDose);

	public void habilitarCidadaoParaVacinacao(int dosesDisponiveis, PerfilVacinacao perfil, int numeroDaDose);
}
