/**
 * 
 */
package com.zup.excepton;

import org.springframework.http.HttpStatus;

/**
 * @author edersongs
 *
 */
public class CoordenadaException extends Exception {

	private static final long serialVersionUID = 3538946384830078481L;

	public CoordenadaException() {
		super();
	}

	public CoordenadaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CoordenadaException(String message) {
		super(message);
	}

	public CoordenadaException(Throwable cause) {
		super(cause);
	}
	
	public CoordenadaException(int status, String message) {
		super(message);
	}
}
