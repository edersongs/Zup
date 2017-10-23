/**
 * 
 */
package com.zup.service.exception;

/**
 * @author Éderson Gervásio
 * 		edersongervasiosilva@gmail.com
 *
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
