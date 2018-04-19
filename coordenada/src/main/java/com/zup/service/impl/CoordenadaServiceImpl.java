/**
 * 
 */
package com.zup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.model.Coordenada;
import com.zup.repository.RepositorioCoordenada;
import com.zup.service.CoordenadaService;
import com.zup.service.exception.CoordenaServiceException;

/**
 * @author Éderson Gervásio
 *		   edersongervasiosilva@gmail.com
 *  	   linkedin.com/in/edersongs
 *  	   github.com/edersongs	
 *  	   + 55 (34) 9 9272-2350
 */
@Service
public class CoordenadaServiceImpl implements CoordenadaService {

	@Autowired private RepositorioCoordenada repositorioCoordenada;
	
	@Override
	public Coordenada salvarCoordenada(Coordenada coordenada) throws CoordenaServiceException {
		
		return repositorioCoordenada.save(coordenada);
		
	}
}
