package com.projeto.vacinaja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.projeto.vacinaja.model.usuario.Usuario;

public interface UsuarioService extends UserDetailsService {

	public void cadastrarUsuario(Usuario usuario);

	public List<Usuario> listarUsuarios();
	
	public Optional<Usuario> retornaUsuarioPeloId(Long id);
}
