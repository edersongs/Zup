/**
 * 
 */
package com.zup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Configuration;

/**
 * @author Éderson Gervásio
 *		   edersongervasiosilva@gmail.com
 *  	   linkedin.com/in/edersongs
 *  	   github.com/edersongs	
 *  	   + 55 (34) 9 9272-2350
 */
@Entity
@Configuration
public class Coordenada {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Min(value=0, message="Posicao X deve ser Positiva")
	private int posicaoX;
	
	@Min(value=0, message="Posicao Y deve ser Positiva")
	private int posicaoY;
	
	@NotBlank(message="Nome deve ser informado")
	private String nome;
	
	public Coordenada(){}
	
	public Coordenada(String nome, int posicaoX, int posicaoY) {
		
		this.nome = nome;
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPosicaoX() {
		return posicaoX;
	}
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}
	
	public int getPosicaoY() {
		return posicaoY;
	}
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
	
	/**
	 * Método realiza o cálculo da distância entre dois pontos
	 * 
	 * Formúla: d = Raiz((x1 - x2)^2 + (y1 - y2)^2)
	 * 
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @return
	 */
	public double calcularDistanciaEntrePontos(int x1, int x2, int y1, int y2) {
		
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}
	
	public int calcularValorMaximoParaPosicaoPelaDistancia(int posicao, int distancia) {
		
		return posicao + distancia;
	}
	
	public int calcularValorMinimo1ParaPosicaoPelaDistancia(int posicao, int distancia) {
		
		return posicao - distancia;
	}
}
