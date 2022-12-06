package com.example.demo;

import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// TODO Auto-generated method stub
	auth.inMemoryAuthentication()
	.withUser("user")
	.password("$2a$10$5FqczKvoYB73wDnKytFiC.bB1YnrU5zuc0WrxYyqBpc8.9e/Et.4C")
	.roles("USER")
	.and()
	.withUser("admin")
	.password("$2a$10$5FqczKvoYB73wDnKytFiC.bB1YnrU5zuc0WrxYyqBpc8.9e/Et.4C")
	.roles("ADMIN");
}@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("ADMIN","USER")
		.antMatchers("/").permitAll()
		.and()
		.formLogin();
	}
	@Bean
	public PasswordEncoder getPassWordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
