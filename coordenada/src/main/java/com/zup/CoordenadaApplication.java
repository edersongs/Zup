 package com.zup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zup.model.Coordenada;
import com.zup.repository.RepositorioCoordenada;

/**
 * @author Éderson Gervásio
 *		   edersongervasiosilva@gmail.com
 *  	   linkedin.com/in/edersongs
 *  	   github.com/edersongs	
 *  	   + 55 (34) 9 9272-2350
 */
@SpringBootApplication
public class CoordenadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoordenadaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner iniciar(RepositorioCoordenada repositorioCoordenada) {
		
		return (args) -> {
		
			repositorioCoordenada.save(new Coordenada("Lanchonete", 27, 12));
			repositorioCoordenada.save(new Coordenada("Posto", 31, 18));
			repositorioCoordenada.save(new Coordenada("Joalheria", 15, 12));
			repositorioCoordenada.save(new Coordenada("Floricultura", 19, 21));
			repositorioCoordenada.save(new Coordenada("Pub", 12, 8));
			repositorioCoordenada.save(new Coordenada("Supermercado", 23, 6));
			repositorioCoordenada.save(new Coordenada("Churrascaria", 28, 2));
		};
	}
}
