package com.hcl.microservices.user2.security;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;


@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http
			.authorizeExchange()
				//.pathMatchers("/login", "/webjars/**").permitAll()
				.anyExchange().authenticated()
				.and()
			.httpBasic().and()
			.formLogin()
			.and().csrf().disable();
				//.loginPage("/login");
		return http.build();
	}
	
//    @Bean
//    public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
//        return http.authorizeExchange()
//            .pathMatchers("/admin").hasAuthority("ROLE_ADMIN")
//            .anyExchange().authenticated()
//            .and().formLogin()
//            .and().csrf().disable()
//            .build();
//    }
	
    @Bean
    MapReactiveUserDetailsService userDetailsService() {
    	UserDetails user = User
				.withUsername("user")
				.password("$2a$10$vi2G21TwA7ILzodh76Zd4OsBXRbA6byKWOygrFYRWualBGwhT9lQi") //encoded password using PasswordGenerator file
				.roles("USER")
				.build();

    	UserDetails admin = User
				.withUsername("admin")
				.password("$2a$10$1vdE3L16afcnPbog0IWzcuML6CqaEug38ZegEZYGHa965V5be5i76")
				.roles("ADMIN")
				.build();

    	return new MapReactiveUserDetailsService(user, admin);
    }

	@Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

}
