package com.upgrad.UpgradB11Springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class MyWebSecurity3 {

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
				
                .requestMatchers(
                    "/supplier/login",
                    "/supplier/403",
                    "/supplier/getAllSuppliers",
                    "/supplier/saveSuppliers"
                ).permitAll()
                
				.requestMatchers("/supplier/showAllSuppliers", "/supplier/addSupplierForm", "/supplier/getAllSuppliers")
				.hasAnyAuthority("USER", "ADMIN")

				.requestMatchers("/supplier/deletSupplier/**", "/supplier/updateSupplierForm/**").hasAuthority("ADMIN")

				.anyRequest().authenticated())

				.formLogin(form -> form.disable())
				
	            .httpBasic(basic -> basic.disable())

	            .logout(logout -> logout
	            	    .logoutUrl("/logout")
	            	    .logoutSuccessHandler((request, response, authentication) -> {
	            	        response.setStatus(HttpServletResponse.SC_OK);
	            	        //response.getWriter().write("Logout successful");
	            	    })
	            	    .permitAll()
	            	)

				 .cors(cors -> {})
					
		            .csrf(csrf -> csrf.disable());
		
		        return http.build();
	}
	
	  @Bean
	    public AuthenticationManager authenticationManager(
	            AuthenticationConfiguration configuration) throws Exception {

	        return configuration.getAuthenticationManager();
	    }

}
