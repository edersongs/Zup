/**
 * 
 */
package com.zup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.repository.RepositorioCoordenada;

/**
 *	@author Éderson Gervásio
 * 	Email: edersongervasiosilva@gmail.com  
 * 	Data   26/04/2017
 *
 */
@Service
public class CoordenadaService {

	@Autowired private RepositorioCoordenada repositorioCoordenada;
	
	public boolean isProximo(int x, int y, int max) {
		
		return false;
	}
}
