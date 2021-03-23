package com.backend.comercio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Util {
	public static String generarCodigo(String codigo, long conteo){
        String rellenoConteo = String.format("%06d" , conteo);
        return codigo + rellenoConteo;
    }
    
    public static String guardarArchivo(MultipartFile archivo, long consecutivo, String carpeta ) throws Exception 
    {
		try {
			String ruta=consecutivo+archivo.getOriginalFilename();
	        File archivo_convertir = new File(carpeta, ruta );
	        FileOutputStream archivo_salida = new FileOutputStream( archivo_convertir );
	        archivo_salida.write( archivo.getBytes() );
	        archivo_salida.close();
	        return ruta;
		}catch(IOException e) {
			throw new Exception();
		}
    }
    
}
