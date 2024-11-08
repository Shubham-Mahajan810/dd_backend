package com.iet.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.iet.filter.JwtFilter;
import com.iet.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtFilter JwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("\n---SECURITY CONFIG - configure AuthenticationManagerBuilder ---\n");
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		System.out.println("\n---------- Building AuthenticationManager bean -------------\n");
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("\n---SECURITY CONFIG2 - configure 2 ---\n");
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint((request, response, ex) -> {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
		}).and().authorizeRequests().antMatchers("/user/**").permitAll().antMatchers("/product/**").permitAll()
				.antMatchers("/address/**").permitAll().antMatchers("/cart/**").permitAll().antMatchers("/category/**")
				.permitAll().antMatchers("/order/**").permitAll().antMatchers("/swagger*/**", "/v*/api-docs/**")
				.permitAll().antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(JwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
