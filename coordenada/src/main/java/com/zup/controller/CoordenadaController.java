/**
 * 
 */
package com.zup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.model.Coordenada;
import com.zup.repository.RepositorioCoordenada;

/**
 * @author Éderson Gervásio
 * 		   edersongervasiosilva@gmail.com
 * 		   26/04/2017  
 *
 */
@RestController
@RequestMapping(value="/api")
public class CoordenadaController {

	@Autowired private Coordenada coordenada;
	@Autowired private RepositorioCoordenada repositorioCoordenada;
	
	@GetMapping("/listarCoordenadas")
	public ResponseEntity<List<Coordenada>> listarTodasCoordenadas() {
		return new ResponseEntity<List<Coordenada>>(repositorioCoordenada.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/proximidades/{posicaoX}/{posicaoY}/{distanciaMax}")
	public ResponseEntity<List<Coordenada>> listarPorProximidade(@PathVariable int posicaoX, @PathVariable int posicaoY, @PathVariable int distanciaMax) {
		return new ResponseEntity<List<Coordenada>>(getCoordenadasPorDistancia(posicaoX, posicaoY, distanciaMax), HttpStatus.OK);
	}
	
	@PostMapping(path ="/salvar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void salvarPontosInteresse(@RequestBody Coordenada coordenada) {
		this.repositorioCoordenada.save(coordenada);
	}
	
	private List<Coordenada> getCoordenadasPorDistancia(int posicaoX, int posicaoY, int distanciaMax) {
		List<Coordenada> pontoProximos = new ArrayList<Coordenada>();
		repositorioCoordenada.proximidade(
				this.coordenada.calcularValorMaximoPosicaoPorDistancia(posicaoX, distanciaMax), 
				this.coordenada.calcularValorMinimoPosicaoPorDistancia(posicaoX, distanciaMax), 
				this.coordenada.calcularValorMaximoPosicaoPorDistancia(posicaoY, distanciaMax), 
				this.coordenada.calcularValorMinimoPosicaoPorDistancia(posicaoY, distanciaMax))
			.forEach(c -> {
				if(this.coordenada.calcularDistanciaEntrePontos(posicaoX, c.getPosicaoX(), posicaoY, c.getPosicaoY()) <= distanciaMax);
				pontoProximos.add(c);
			});
		return pontoProximos;
	}
}
