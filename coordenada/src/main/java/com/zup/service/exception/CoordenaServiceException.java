/**
 * 
 */
package com.zup.service.exception;

/**
 * @author Éderson Gervásio
 *		   edersongervasiosilva@gmail.com
 *  	   linkedin.com/in/edersongs
 *  	   github.com/edersongs	
 *  	   + 55 (34) 9 9272-2350
 */
public class CoordenaServiceException extends Exception {

	private static final long serialVersionUID = 368511963559467116L;

	public CoordenaServiceException() {}

    public CoordenaServiceException(String message) {
        super(message);
    }

    public CoordenaServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoordenaServiceException(Throwable cause) {
        super(cause);
    }
}
