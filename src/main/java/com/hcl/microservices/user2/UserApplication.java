package com.hcl.microservices.user2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.server.reactive.HttpHandler;
//import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.reactive.config.EnableWebFlux;
//import org.springframework.web.server.adapter.WebHttpHandlerBuilder;

//import reactor.netty.DisposableServer;
//import reactor.netty.http.server.HttpServer;

//import com.hcl.microservices.user.model.UserEntity;
//import com.hcl.microservices.user.repository.UserRepository;

//import reactor.core.publisher.Mono;

//@ComponentScan(basePackages = {"com.baeldung.security"})
//@EnableWebFlux
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
//		try (AnnotationConfigApplicationContext context 
//		         = new AnnotationConfigApplicationContext(
//		        		 UserApplication.class)) {
//		 
//			context.getBean(DisposableServer.class).onDispose().block();
//		        }
		
		SpringApplication.run(UserApplication.class, args);
	}
	
//    @Bean
//    public DisposableServer disposableServer(ApplicationContext context) {
//        HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context)
//                .build();
//        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
//        HttpServer httpServer = HttpServer.create().host("localhost").port(9000);
//        return httpServer.handle(adapter).bindNow();
//    }
    
    
	
//	@Bean
//	public CommandLineRunner Userclr(UserRepository userRepo) {
//		return (args) -> {
//			
//			System.out.println("\n*****************************");
//			Mono<UserEntity> userentity = repository.existsById(id);
//			
//		};
//	}
	

}
