package com.projeto.vacinaja.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.projeto.vacinaja.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService userService;
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().
		authorizeRequests().
		antMatchers("/api/*").hasAuthority("ADMIN").
		antMatchers("/api/cidadao/*").hasAnyAuthority("CIDADAO", "ADMIN").
		antMatchers("/api/funcionario/*").hasAnyAuthority("FUNCIONARIO", "ADMIN").
		antMatchers("/api/vacina/*").hasAnyAuthority("FUNCIONARIO", "ADMIN").
		anyRequest().authenticated().and().formLogin().defaultSuccessUrl("http://localhost:8080/swagger-ui.html").
		failureUrl("/login?error=true").permitAll()
		.and()
		.logout().logoutSuccessUrl("/login").permitAll();
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                                   "/configuration/ui",
                                   "/swagger-resources/**",
                                   "/configuration/security",
                                   "/swagger-ui.html",
                                   "/webjars/**");
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication().
//		withUser("func").
//		password(passwordEncoder().encode("password")).authorities("FUNCIONARIO").
//		and().
//		withUser("user").
//		password(passwordEncoder().encode("password")).authorities("CIDADAO");
		
		auth.authenticationProvider(authenticationProvider());
	}
}
