package com.backend.comercio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Constantes {
	public static final String CLIENTECONTROLLER = "/comercio/cliente";
	public static final String PRODUCTOCONTROLLER = "/comercio/producto";
	public static final String PARAMETROCONTROLLER = "/comercio/parametro";
	public static final String PEDIDOCONTROLLER = "/comercio/pedido";
	public static final String USUARIOCONTROLLER = "/comercio/usuario";
	public static final String SESIONCONTROLLER = "/comercio/sesion";
	
	public static final String LOGMETHOD = "Ingresa al método: ";
	public static final String LOGCLASS = " de la clase: ";
	public static String codigoPedido="FAC";
	
	public static final String NO_CONFIRMADOS="NO CONFIRMADOS";
	public static final String NO_PAGADOS="NO PAGADOS";
	public static final String NO_ENVIADOS="NO ENVIADOS";
	
	public static String guardarArchivo(MultipartFile archivo, long consecutivo ) throws Exception 
    {
		try {
			String ruta=consecutivo+archivo.getOriginalFilename();
	        File archivo_convertir = new File("src/main/upload", ruta );
	        FileOutputStream archivo_salida = new FileOutputStream( archivo_convertir );
	        archivo_salida.write( archivo.getBytes() );
	        archivo_salida.close();
	        return ruta;
		}catch(IOException e) {
			throw new Exception();
		}
    }

}
