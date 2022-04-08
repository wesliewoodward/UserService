package com.hcl.microservices.user2.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.hcl.microservices.user2.model.UserEntity;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {

	Mono<UserDetails> findByEmail(String username);

}
