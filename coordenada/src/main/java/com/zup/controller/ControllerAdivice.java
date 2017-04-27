/**
 * 
 */
package com.zup.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zup.excepton.CoordenadaException;

/**
 * @author Éderson Gervásio
 * 		   edersongervasiosilva@gmail.com
 * 		   27/04/2017  
 *
 */
@ControllerAdvice
@RestController
public class ControllerAdivice {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(value = CoordenadaException.class)  
    public String handleBaseException(CoordenadaException e){  
        return e.getMessage();  
    }  
  
    @ExceptionHandler(value = Exception.class)  
    public String handleException(Exception e){return e.getMessage();}
}
