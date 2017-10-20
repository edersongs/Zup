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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.model.Coordenada;
import com.zup.repository.RepositorioCoordenada;

/**
 * @author Éderson Gervásio
 * 		   edersongervasiosilva@gmail.com
 *
 */
@RestController
@RequestMapping(value="/coordenadas")
public class CoordenadaController {

	@Autowired private Coordenada coordenada;
	@Autowired private RepositorioCoordenada repositorioCoordenada;
	
	/**
	 * 
	 * 		Listar todas as coordenadas registradas.
	 * 
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Coordenada>> listarTodasCoordenadas() {
		
		return new ResponseEntity<List<Coordenada>>(repositorioCoordenada.findAll(), HttpStatus.BAD_GATEWAY);
	}
	
	/**
	 * 
	 *		Lista as coordenadas cadastradas que estão mais próximas de acordo com a distância informada.
	 *
	 * 
	 * @param posicaoX
	 * @param posicaoY
	 * @param distanciaMax
	 * @return
	 */
	@GetMapping("/proximidades")
	public ResponseEntity<List<Coordenada>> listarPorProximidade(int posicaoX, int posicaoY, int distanciaMax) {
		
		List<Coordenada> pontoProximos = repositorioCoordenada.findAll()
				.stream()
				.filter(c -> coordenada.calcularDistanciaEntrePontos(posicaoX, c.getPosicaoX(), posicaoY, c.getPosicaoY()) <= distanciaMax)
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<Coordenada>>(pontoProximos, HttpStatus.OK);
	}
	
	/**
	 * 
	 *		Solução para encontrar as coordenadas cadastradas que estão mais próximas, de acordo com a distância informada.
	 *		Essa solução não realiza um findAll na base para realizar o cálculo das coordenadas como é realizado no método listarPorProximidade.
	 * 
	 * @param posicaoX
	 * @param posicaoY
	 * @param distanciaMax
	 * @return
	 */
	@GetMapping("/proximidades2")
	private List<Coordenada> getCoordenadasPorDistancia(int posicaoX, int posicaoY, int distanciaMax) {
		
		return repositorioCoordenada
				.proximidade(coordenada.calcularValorMaximoPosicaoPorDistancia(posicaoX, distanciaMax),
						coordenada.calcularValorMinimoPosicaoPorDistancia(posicaoX, distanciaMax),
						coordenada.calcularValorMaximoPosicaoPorDistancia(posicaoY, distanciaMax),
						coordenada.calcularValorMinimoPosicaoPorDistancia(posicaoY, distanciaMax))
				.stream()
				.filter(c -> coordenada.calcularDistanciaEntrePontos(posicaoX, c.getPosicaoX(), posicaoY,	c.getPosicaoY()) <= distanciaMax)
				.collect(Collectors.toList());
	}
	
	/**
	 * 	
	 * 		Salvar pontos de interesse.
	 * 
	 * 
	 * @param coordenada
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> salvarPontosInteresse(@RequestBody Coordenada coordenada) {
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
