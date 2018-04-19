/**
 * 
 */
package com.zup.service;

import com.zup.model.Coordenada;
import com.zup.service.exception.CoordenaServiceException;

/**
 * @author Éderson Gervásio
 *		   edersongervasiosilva@gmail.com
 *  	   linkedin.com/in/edersongs
 *  	   github.com/edersongs	
 *  	   + 55 (34) 9 9272-2350
 */
public interface CoordenadaService {

	public Coordenada salvarCoordenada(Coordenada coordenada) throws CoordenaServiceException;
}
