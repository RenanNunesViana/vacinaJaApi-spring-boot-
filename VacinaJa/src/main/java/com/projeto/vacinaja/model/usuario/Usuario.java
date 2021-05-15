package com.projeto.vacinaja.model.usuario;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {
	
	@Id
	protected String cpf;
	protected String nomeCompleto;
	protected String endereco;
	protected String email;
	protected String dataNascimento;
	protected String telefone;
	protected String comorbidade;
	protected int idade;
	public String userName;
	public String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "cpf"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"))
	public Collection<Role> roles;
	
	public Usuario() {
	}
	
	public Usuario(String nomeCompleto, String endereco, String cpf, String email, String dataNascimento,
			String telefone, String comorbidade, String username, String password, Collection<Role> roles) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.endereco = endereco;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.userName = username;
		this.password = password;
		this.roles = roles;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getComorbidade() {
		return comorbidade;
	}
	
	public int getIdade() {
		return this.idade;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
}
