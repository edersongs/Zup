/**
 * 
 */
package com.zup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.model.Coordenada;
import com.zup.repository.RepositorioCoordenada;
import com.zup.service.exception.CoordenaServiceException;
import com.zup.service.interfaces.CoordenadaService;

/**
 * @author Éderson Gervásio
 * 		edersongervasiosilva@gmail.com
 *
 */
@Service
public class CoordenadaServiceImpl implements CoordenadaService {

	@Autowired private RepositorioCoordenada repositorioCoordenada;
	
	@Override
	public void salvarCoordenada(Coordenada coordenada) throws CoordenaServiceException {
		
		repositorioCoordenada.save(coordenada);
		
	}
}
