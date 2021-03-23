package com.backend.comercio.exception;

import com.backend.comercio.Constantes;

public class SesionInvalidaException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SesionInvalidaException() {
        super(Constantes.error_codigo_sesion_invalida);
    }
}
