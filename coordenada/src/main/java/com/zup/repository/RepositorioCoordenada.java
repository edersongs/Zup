/**
 * 
 */
package com.zup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zup.model.Coordenada;


/**
 * @author Éderson Gervásio
 *		   edersongervasiosilva@gmail.com
 *  	   linkedin.com/in/edersongs
 *  	   github.com/edersongs	
 *  	   + 55 (34) 9 9272-2350
 */
@Repository
public interface RepositorioCoordenada extends JpaRepository<Coordenada, Long> {

	/**
	 * 
	 * Método filtra somente as Coordenas de acordo com o limite 
	 * máximo e minimo que cada posição pode assumir referente a distância informada.
	 * 
	 * Evitando um findAll na base de todas coordenadas.
	 * 
	 * @param posicaoX_Max
	 * @param posicaoX_Min
	 * @param posicaoY_Max
	 * @param posicaoY_Min
	 * @return
	 */
	@Query("from Coordenada "
			+ "where posicaoX <= :posicaoX_Max "
			+ "and posicaoX >= :posicaoX_Min "
			+ "and posicaoY <= :posicaoY_Max "
			+ "and posicaoY >= :posicaoY_Min")
	List<Coordenada> obtemProximidades(
			@Param("posicaoX_Max") int posicaoX_Max, 
			@Param("posicaoX_Min") int posicaoX_Min,
			@Param("posicaoY_Max") int posicaoY_Max, 
			@Param("posicaoY_Min") int posicaoY_Min);
}
