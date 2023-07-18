package com.springboot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc  //for swagger
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyConfig  extends WebSecurityConfigurerAdapter{

	 public static final String[] PUBLIC_URLS= {
	  "api/v1/auth/**",
	  "/v3/api-docs",
	  "/v2/api-docs",
	  "/swagger-resources/**",
	  "/swagger-ui/**",
	  "/webjars/**",
	  
	 };
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		    .antMatchers("/login","/register","/home").permitAll()
		    .antMatchers("/public/**").permitAll()
		    .antMatchers("/users/**").hasRole("ADMIN")
		    .antMatchers("/v3/api-docs").permitAll()
		    .antMatchers(HttpMethod.GET).permitAll()
		    .anyRequest()
		    .authenticated()
		    .and()
		    .httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("pritam").password(this.passwordEncoder().encode("rajput")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("xyz").password(this.passwordEncoder().encode("abc")).roles("NORMAL");
	}

	@Bean
	public PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder(10);
	}
	
}
