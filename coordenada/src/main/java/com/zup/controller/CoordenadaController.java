/**
 * 
 */
package com.zup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.model.Coordenada;
import com.zup.repository.RepositorioCoordenada;

/**
 * @author Éderson Gervásio
 * @email: edersongervasiosilva@gmail.com  
 * @data   26/04/2017
 *
 */
@RestController
@RequestMapping(value="/api")
public class CoordenadaController {

	@Autowired private RepositorioCoordenada repositorioCoordenada;
	
	@GetMapping("/listarCoordenadas")
	public ResponseEntity<List<Coordenada>> listarTodasCoordenadas() {
		return new ResponseEntity<List<Coordenada>>(repositorioCoordenada.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/proximidades")
	public ResponseEntity<List<Coordenada>> listarPorProximidade(int coordenadaX, int coordenadaY, int distanciaMax) {
		List<Coordenada> pontoProximos = new ArrayList<Coordenada>();
		repositorioCoordenada.findAll().forEach(c -> {
				if (this.calcular(coordenadaX, c.getCoordenadaX(), coordenadaY, c.getCoordenadaY(), distanciaMax) < distanciaMax) {
					pontoProximos.add(c);
				}
			}
		);
		return new ResponseEntity<List<Coordenada>>(pontoProximos, HttpStatus.OK);
	}
	
	@PostMapping("/salvar")
	public void salvarPontosInteresse(String nome, int coordenadaX, int coordenadaY) {
		this.repositorioCoordenada.save(new Coordenada(nome, coordenadaX, coordenadaY));
	}
	
	public double calcular(int x1, int x2, int y1, int y2, int max) {
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}
}
