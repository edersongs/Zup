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
	
	@GetMapping("/proximidades")
	public ResponseEntity<List<Coordenada>> listarPorProximidade(int posicaoX, int posicaoY, int distanciaMax) {
		List<Coordenada> pontoProximos = new ArrayList<Coordenada>();
		repositorioCoordenada.findAll().forEach(c -> {
				if (this.coordenada.calcularDistanciaEntrePontos(posicaoX, c.getPosicaoX(), posicaoY, c.getPosicaoY()) < distanciaMax) {
					pontoProximos.add(c);
				}
			}
		);
		return new ResponseEntity<List<Coordenada>>(pontoProximos, HttpStatus.OK);
	}
	
	/**
	 * Salva os dados do teste
	 * 
	 * @return
	 */
	@GetMapping("/salvarPadrao")
	public void salvarPadrao() {
		List<Coordenada> coordenadas = new ArrayList<Coordenada>();
		coordenadas.add(new Coordenada("Lanchonete", 27, 12));
		coordenadas.add(new Coordenada("Posto", 31, 18));
		coordenadas.add(new Coordenada("Joalheria", 15, 12));
		coordenadas.add(new Coordenada("Floricultura", 19, 21));
		coordenadas.add(new Coordenada("Pub", 12, 8));
		coordenadas.add(new Coordenada("Supermercado", 23, 6));
		coordenadas.add(new Coordenada("Churrascaria", 28, 2));
		coordenadas.forEach(c -> this.salvarPontosInteresse(c));
	}
	
	@PostMapping(path ="/salvar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String salvarPontosInteresse(@RequestBody Coordenada coordenada) {
		this.repositorioCoordenada.save(coordenada);
		return "Salvo com Sucesso!";
	}
	
	/**
	 * Nova solução para encontrar as cordenadas pela distância maxima.
	 * Esse solução não faz um findAll direto na base.
	 * 
	 * Não está sendo usada por falta de prazo para teste!
	 * 
	 * @param posicaoX
	 * @param posicaoY
	 * @param distanciaMax
	 * @return
	 */
	private List<Coordenada> getCoordenadasPorDistancia(int posicaoX, int posicaoY, int distanciaMax) {
		List<Coordenada> pontoProximos = new ArrayList<Coordenada>();
		repositorioCoordenada.proximidade(
				this.coordenada.calcularValorMaximoPosicaoPorDistancia(posicaoX, distanciaMax), 
				this.coordenada.calcularValorMinimoPosicaoPorDistancia(posicaoX, distanciaMax), 
				this.coordenada.calcularValorMaximoPosicaoPorDistancia(posicaoY, distanciaMax), 
				this.coordenada.calcularValorMinimoPosicaoPorDistancia(posicaoY, distanciaMax))
			.forEach(c -> {
				if(this.coordenada.calcularDistanciaEntrePontos(posicaoX, c.getPosicaoX(), posicaoY, c.getPosicaoY()) < distanciaMax);
				pontoProximos.add(c);
			});
		return pontoProximos;
	}
}
