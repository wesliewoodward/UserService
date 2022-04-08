package com.hcl.microservices.user2.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.microservices.user2.model.UserEntity;
import com.hcl.microservices.user2.repository.UserRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/")
	public Mono<String> welcome(Mono<Principal> principal) {
		return principal
				.map(Principal::getName)
				.map(this::welcomeMessage);
	}
	
	private String welcomeMessage(String username) {
		return "Welcome " + username + "!";
	}

	
	@RequestMapping(value = "/users/all", method = RequestMethod.GET, produces = {"application/json"})
	public Flux<UserEntity> getAllUsers() {
		Flux<UserEntity> users = repository.findAll();
		return users;
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity<Mono<UserEntity>> getUserById(@PathVariable Long id) {
		Mono<UserEntity> userentity = repository.findById(id);
		HttpStatus status = userentity != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<UserEntity>>(userentity, status);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
	public Mono<UserEntity> createUser(@RequestBody(required=true) UserEntity CreateUser) {
		long startTime = System.currentTimeMillis();
		log.info("Entering UserContoller.createUser method " + CreateUser);
		Mono<UserEntity> usersResponse = repository.save(CreateUser);
		log.info("Exiting the UserController.createUser method \n", System.currentTimeMillis()-startTime);
		return usersResponse;
	}
	
	@RequestMapping(value = "/users/delete/{id}", method=RequestMethod.DELETE, produces= {"application/json"})
	public Mono<Void> deleteUser(@PathVariable Long id) {
		return repository.findById(id)
				.flatMap(entity -> {
					return repository.delete(entity);
				});
	}

}
