/**
 * 
 */
package com.zup.service.interfaces;

import com.zup.model.Coordenada;
import com.zup.service.exception.CoordenaServiceException;

/**
 * @author Éderson Gervásio
 *
 */
public interface CoordenadaService {

	public void salvarCoordenada(Coordenada coordenada) throws CoordenaServiceException;
}
