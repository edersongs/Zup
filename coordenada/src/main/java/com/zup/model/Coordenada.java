/**
 * 
 */
package com.zup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Éderson Gervásio
 * Email: edersongervasiosilva@gmail.com * 
 * Data   26/04/2017
 *
 */
@Entity
public class Coordenada {
	
	private int codigo;
	private int coordenadaX;
	private int coordenadaY;
	private String nome;
	
	public Coordenada(){}
	
	public Coordenada(String nome, int coordenadaX, int coordenadaY) {
		this.nome = nome;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public int getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public int getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
}
