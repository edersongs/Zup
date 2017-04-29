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
 * 		   edersongervasiosilva@gmail.com
 * 		   26/04/2017  
 *
 */
@Repository
public interface RepositorioCoordenada extends JpaRepository<Coordenada, Long> {

	/**
	 * 
	 * Método filtra somente as Coordenas de acordo com o limite máximo e minimo que cada posição pode assumir de acordo com a distância informada!
	 * Evitando um findAll na base de todas coordenadas.
	 * 
	 * @param posicaoXMax
	 * @param posicaoXMin
	 * @param posicaoYMax
	 * @param posicaoYMin
	 * @return
	 */
	@Query("from Coordenada where posicaoX <= :posicaoXMax and posicaoX >= :posicaoXMin and posicaoY <= :posicaoYMax and posicaoY >= :posicaoYMin" )
	List<Coordenada> proximidade(
			@Param("posicaoXMax") int posicaoXMax, 
			@Param("posicaoXMin") int posicaoXMin,
			@Param("posicaoYMax") int posicaoYMax, 
			@Param("posicaoYMin") int posicaoYMin);
}
