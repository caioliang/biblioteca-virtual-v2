package br.com.fiap.biblioteca_virtual_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@EnableCaching
@OpenAPIDefinition(
	info = @Info(
		title = "API Biblioteca Virtual", 
		version = "v1", 
		description = "API de SaaS para gerenciamento de livros", 
		contact = @Contact(name = "Caio Liang e Celina Alcantra", 
		email = "rm558868@fiap.com.br e RM558090@fiap.com.br" )))

public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
