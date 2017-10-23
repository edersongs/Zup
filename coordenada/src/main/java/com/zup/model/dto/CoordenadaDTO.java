/**
 * 
 */
package com.zup.model.dto;

/**
 * @author Éderson Gervásio
 * 	      edersongervasiosilva@gmail.com
 *
 */
public class CoordenadaDTO {
	
	private int posicaoX;
	private int posicaoY;
	private String nome;
	
	public CoordenadaDTO(String nome, int posicaoX, int posicaoY) {
		this.nome = nome;
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
