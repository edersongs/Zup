/**
 * 
 */
package com.zup.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import com.zup.service.CoordenadaService;
import com.zup.service.exception.CoordenaServiceException;

/**
 * @author Éderson Gervásio
 *		   edersongervasiosilva@gmail.com
 *  	   linkedin.com/in/edersongs
 *  	   github.com/edersongs	
 *  	   + 55 (34) 9 9272-2350
 */
@RestController
@RequestMapping(value="/coordenadas")
public class CoordenadaController {

	@Autowired private RepositorioCoordenada repositorioCoordenada;
	@Autowired private CoordenadaService coordenadaService;
	@Autowired private Coordenada coordenada;
	
	@GetMapping
	public ResponseEntity<List<Coordenada>> listarTodasCoordenadas() {
		
		return new ResponseEntity<List<Coordenada>>(
				repositorioCoordenada.findAll(), HttpStatus.OK);
	}
	
	/**
	 * 
	 *	Solução para encontrar as coordenadas cadastradas 
	 *	que estão mais próximas de acordo com a distância informada.
	 *
	 *	Essa solução não realiza um findAll na base para realizar o cálculo da distância.
	 * 
	 * @param posicaoX
	 * @param posicaoY
	 * @param distanciaMax
	 * @return
	 */
	@GetMapping("/proximidades/{posicaoX}/{posicaoY}/{distanciaMaxima}")
	private List<Coordenada> pesquisarCoordenadasPelaDistancia(
			@PathVariable int posicaoX, 
			@PathVariable int posicaoY, 
			@PathVariable int distanciaMaxima) {
		
		return repositorioCoordenada
				.obtemProximidades(
						coordenada.calcularValorMaximoParaPosicaoPelaDistancia(posicaoX, distanciaMaxima),
						coordenada.calcularValorMinimo1ParaPosicaoPelaDistancia(posicaoX, distanciaMaxima),
						coordenada.calcularValorMaximoParaPosicaoPelaDistancia(posicaoY, distanciaMaxima),
						coordenada.calcularValorMinimo1ParaPosicaoPelaDistancia(posicaoY, distanciaMaxima))
				.stream()
				.filter(c 
						-> coordenada.calcularDistanciaEntrePontos(
								posicaoX, 
								c.getPosicaoX(), 
								posicaoY, 
								c.getPosicaoY())
						<= distanciaMaxima)
				
				.collect(Collectors.toList());
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> salvarPontosInteresse(@RequestBody Coordenada coordenada) throws CoordenaServiceException {
		
		return new ResponseEntity<>(coordenadaService.salvarCoordenada(coordenada), HttpStatus.CREATED);
	}
}
