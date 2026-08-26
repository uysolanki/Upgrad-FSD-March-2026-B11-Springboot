package com.upgrad.UpgradB11Springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyWebSecurity {
	
	 //Authentication
	 @Bean
	    public UserDetailsService userDetailsService() {

	        UserDetails admin1 = User.builder()
	                .username("jetha")
	                .password(passwordEncoder().encode("jetha123"))
	                .authorities("ADMIN")  //CRUD
	                .build();
	      

	        UserDetails user1 = User.builder()
	                .username("bagha")
	                .password(passwordEncoder().encode("bagha123"))
	                .authorities("USER")  //CR
	                .build();
	      

	        return new InMemoryUserDetailsManager(admin1,user1);
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	        http
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers(
	                    "/supplier/showAllSuppliers",
	                    "/supplier/addSupplierForm"
	                ).hasAnyAuthority("USER", "ADMIN")

	                .requestMatchers(
	                    "/supplier/deletSupplier/**",
	                    "/supplier/updateSupplierForm/**"
	                ).hasAuthority("ADMIN")

	                .anyRequest().authenticated()
	            )

	            .formLogin(form -> form
	                .loginProcessingUrl("/login")
	                .successForwardUrl("/supplier/showAllSuppliers")
	                .permitAll()
	            )

	            .logout(logout -> logout
	                .logoutSuccessUrl("/login")
	                .permitAll()
	            )

	            .exceptionHandling(exception -> exception
	                .accessDeniedPage("/supplier/403")
	            )

	            .cors(cors -> {})

	            .csrf(csrf -> csrf.disable());

	        return http.build();
	    }


}
