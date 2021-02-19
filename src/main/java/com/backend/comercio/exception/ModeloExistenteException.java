package com.backend.comercio.exception;

import com.backend.comercio.Util;

public class ModeloExistenteException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModeloExistenteException() {
        super(Util.error_registro_existente);
    }
}
