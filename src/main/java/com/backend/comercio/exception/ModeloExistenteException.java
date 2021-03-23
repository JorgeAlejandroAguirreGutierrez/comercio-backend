package com.backend.comercio.exception;

import com.backend.comercio.Constantes;

public class ModeloExistenteException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModeloExistenteException() {
        super(Constantes.error_codigo_modelo_existente);
    }
}
