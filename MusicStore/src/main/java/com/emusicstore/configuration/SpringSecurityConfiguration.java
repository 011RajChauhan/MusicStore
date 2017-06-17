package com.emusicstore.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Autowired
		DataSource dataSource;
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.and().formLogin()
			.and().exceptionHandling().accessDeniedPage("/access_denied");
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
			auth.inMemoryAuthentication().withUser("rajan").password("chauhan").roles("ADMIN");	
		}
}
