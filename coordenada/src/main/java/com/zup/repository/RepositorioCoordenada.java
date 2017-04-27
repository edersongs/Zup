/**
 * 
 */
package com.zup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.model.Coordenada;

/**
 * @author Éderson Gervásio
 * @email: edersongervasiosilva@gmail.com  
 * @data   26/04/2017
 *
 */
@Repository
public interface RepositorioCoordenada extends JpaRepository<Coordenada, Long> {

}
