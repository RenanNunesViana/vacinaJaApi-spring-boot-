package com.projeto.vacinaja.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.projeto.vacinaja.model.usuario.Role;
import com.projeto.vacinaja.model.usuario.Usuario;
import com.projeto.vacinaja.repository.RoleRepository;
import com.projeto.vacinaja.repository.UsuarioRepository;

@Component
public class DataLoader implements CommandLineRunner{

	@Autowired
	UsuarioRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEnconder;
	
	@Override
	public void run(String... args) throws Exception {
		roleRepository.save(new Role("ADMIN"));
		roleRepository.save(new Role("CIDADAO"));
		roleRepository.save(new Role("FUNCIONARIO"));
		
		Role role1 = roleRepository.findByName("CIDADAO");
		Collection<Role> colRole1 = new HashSet<>();
		colRole1.add(role1);
		
		Usuario user = new Usuario("teste", null, "1", null, null,
				null, null, "teste", passwordEnconder.encode("123456"), colRole1);
		
		userRepository.save(user);
	
	}

}
