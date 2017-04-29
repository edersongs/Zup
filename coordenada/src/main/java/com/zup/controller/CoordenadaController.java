/**
 * 
 */
package com.zup.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	/**
	 * Lista as coordenadas cadastradas que estão mais próximas de acordo com a distância informada.
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
				.filter(c -> this.coordenada.calcularDistanciaEntrePontos(posicaoX, c.getPosicaoX(), posicaoY, c.getPosicaoY()) <= distanciaMax)
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<Coordenada>>(pontoProximos, HttpStatus.OK);
	}
	
	/**
	 * Solução para encontrar as coordenadas cadastradas que estão mais próximas, de acordo com a distância informada.
	 * Essa solução não realiza um findAll na base para realizar o calculo das coordenadas como é realizado no método listarPorProximidade.
	 * 
	 * @param posicaoX
	 * @param posicaoY
	 * @param distanciaMax
	 * @return
	 */
	@GetMapping("/proximidades2")
	private List<Coordenada> getCoordenadasPorDistancia(int posicaoX, int posicaoY, int distanciaMax) {
		return repositorioCoordenada
				.proximidade(this.coordenada.calcularValorMaximoPosicaoPorDistancia(posicaoX, distanciaMax),
						this.coordenada.calcularValorMinimoPosicaoPorDistancia(posicaoX, distanciaMax),
						this.coordenada.calcularValorMaximoPosicaoPorDistancia(posicaoY, distanciaMax),
						this.coordenada.calcularValorMinimoPosicaoPorDistancia(posicaoY, distanciaMax))
				.stream()
				.filter(c -> this.coordenada.calcularDistanciaEntrePontos(posicaoX, c.getPosicaoX(), posicaoY,	c.getPosicaoY()) <= distanciaMax)
				.collect(Collectors.toList());
	}
	
	/**
	 * Salva os dados do teste
	 * 
	 * @return
	 */
	@GetMapping("/salvarPadrao")
	public String salvarPadrao() {
		List<Coordenada> coordenadas = new ArrayList<Coordenada>();
		coordenadas.add(new Coordenada("Lanchonete", 27, 12));
		coordenadas.add(new Coordenada("Posto", 31, 18));
		coordenadas.add(new Coordenada("Joalheria", 15, 12));
		coordenadas.add(new Coordenada("Floricultura", 19, 21));
		coordenadas.add(new Coordenada("Pub", 12, 8));
		coordenadas.add(new Coordenada("Supermercado", 23, 6));
		coordenadas.add(new Coordenada("Churrascaria", 28, 2));
		coordenadas.forEach(c -> this.salvarPontosInteresse(c));
		return "Salvo!";
	}
	
	@PostMapping(path ="/salvar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String salvarPontosInteresse(@RequestBody Coordenada coordenada) {
		this.repositorioCoordenada.save(coordenada);
		return "Salvo com Sucesso!";
	}
}
