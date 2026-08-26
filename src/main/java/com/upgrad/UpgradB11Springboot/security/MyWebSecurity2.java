package com.upgrad.UpgradB11Springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyWebSecurity2 {

	// Authentication

	@Bean
	public PasswordEncoder myPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider myAuthenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider(mySetUserDetailsService());
		dao.setPasswordEncoder(myPasswordEncoder());
		return dao;
	}

	@Bean
	public UserDetailsService mySetUserDetailsService() {
		return new MyUserDetailsService();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authenticationProvider(myAuthenticationProvider());

		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/supplier/showAllSuppliers", "/supplier/addSupplierForm")
				.hasAnyAuthority("USER", "ADMIN")

				.requestMatchers("/supplier/deletSupplier/**", "/supplier/updateSupplierForm/**").hasAuthority("ADMIN")

				.anyRequest().authenticated())

				.formLogin(form -> form.loginProcessingUrl("/login").successForwardUrl("/supplier/showAllSuppliers")
						.permitAll())

				.logout(logout -> logout.logoutSuccessUrl("/login").permitAll())

				.exceptionHandling(exception -> exception.accessDeniedPage("/supplier/403"))

				.cors(cors -> {
				})

				.csrf(csrf -> csrf.disable());

		return http.build();
	}

}
