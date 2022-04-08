package com.hcl.microservices.user2.repository;

import org.springframework.security.core.userdetails.UserDetails;

import reactor.core.publisher.Mono;

public interface ReactiveUserDetailsService {
	
	Mono<UserDetails> findByUsername(String username);

}
