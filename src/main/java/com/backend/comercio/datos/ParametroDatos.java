package com.backend.comercio.datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.backend.comercio.modelos.Parametro;
import com.backend.comercio.repositorios.IParametroRepository;

@Component
@Order(2)
@Profile({"dev","prod"})
public class ParametroDatos implements ApplicationRunner {
	@Autowired
    private IParametroRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Parametro> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<Parametro> parametros= new ArrayList<>();            
            //TALLAS ZAPATOS
            parametros.add(new Parametro("ZAPATOS", "21", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "22", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "23", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "24", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "25", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "26", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "27", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "28", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "29", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "30", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "31", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "32", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "33", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "34", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "35", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "36", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "37", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "38", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "39", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "40", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "41", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "42", "TALLA", true));
            parametros.add(new Parametro("ZAPATOS", "43", "TALLA", true));
            
            //TALLAS BOLSOS
            parametros.add(new Parametro("BOLSOS", "NA", "TALLA", true));
            
            //TALLAS TRAJES DEPORTIVOS
            parametros.add(new Parametro("TRAJES DEPORTIVOS", "XS", "TALLA", true));
            parametros.add(new Parametro("TRAJES DEPORTIVOS", "S", "TALLA", true));
            parametros.add(new Parametro("TRAJES DEPORTIVOS", "M", "TALLA", true));
            parametros.add(new Parametro("TRAJES DEPORTIVOS", "L", "TALLA", true));
            parametros.add(new Parametro("TRAJES DEPORTIVOS", "XL", "TALLA", true));
            parametros.add(new Parametro("TRAJES DEPORTIVOS", "UNICA", "TALLA", true));
            
            //COLORES
            parametros.add(new Parametro(null, "NEGRO", "COLOR", true));
            parametros.add(new Parametro(null, "ROJO", "COLOR", true));
            parametros.add(new Parametro(null, "BLANCO", "COLOR", true));
            parametros.add(new Parametro(null, "AZUL", "COLOR", true));
            parametros.add(new Parametro(null, "GRIS", "COLOR", true));
            parametros.add(new Parametro(null, "BEIGE", "COLOR", true));
            parametros.add(new Parametro(null, "VERDE", "COLOR", true));
            parametros.add(new Parametro(null, "AMARILLO", "COLOR", true));
            parametros.add(new Parametro(null, "NARANJA", "COLOR", true));
            parametros.add(new Parametro(null, "CAFE", "COLOR", true));
            parametros.add(new Parametro(null, "DORADO", "COLOR", true));
            parametros.add(new Parametro(null, "PLATEADO", "COLOR", true));
            parametros.add(new Parametro(null, "AGUMARINA", "COLOR", true));
            parametros.add(new Parametro(null, "ROSADO", "COLOR", true));
            parametros.add(new Parametro(null, "FUCSIA", "COLOR", true));
            parametros.add(new Parametro(null, "VERDEFOSFORECENTE", "COLOR", true));
            parametros.add(new Parametro(null, "CIELO", "COLOR", true));
            parametros.add(new Parametro(null, "CHOCOLATE", "COLOR", true));
            parametros.add(new Parametro(null, "SALMON", "COLOR", true));
            
            parametros.add(new Parametro(null, "TODOS", "ESTADO_PEDIDO", true));
            parametros.add(new Parametro(null, "ABIERTOS", "ESTADO_PEDIDO", true));
            parametros.add(new Parametro(null, "CONFIRMADOS", "ESTADO_PEDIDO", true));
            parametros.add(new Parametro(null, "PAGADOS", "ESTADO_PEDIDO", true));
            parametros.add(new Parametro(null, "ENVIADOS", "ESTADO_PEDIDO", true));
            
            parametros.add(new Parametro("DAVIVIENDA", "AL NUMERO DE CUENTA: 018000456321", "MEDIO_PAGO", true));
            parametros.add(new Parametro("BANCOLOMBIA", "AL NUMERO DE CUENTA: 017000852146", "MEDIO_PAGO", true));
            parametros.add(new Parametro("DAVIPLATA", "AL NUMERO DE CELULAR: 3113395701", "MEDIO_PAGO", true));
            parametros.add(new Parametro("EFECTY", "AL NUMERO DE CEDULA: 1053847607", "MEDIO_PAGO", true));
            
            parametros.add(new Parametro(null, "slider1.jpg", "SLIDER", true));
            parametros.add(new Parametro(null, "slider2.jpg", "SLIDER", true));
            parametros.add(new Parametro(null, "slider3.jpg", "SLIDER", true));
            
            parametros.add(new Parametro(null, "logo1.png", "LOGO", true));
            
            //CAMPOS
            parametros.add(new Parametro("MARCA", "CAMPO MARCA", "CAMPO", true));
            parametros.add(new Parametro("MATERIAL", "CAMPO MATERIAL", "CAMPO", true));
            parametros.add(new Parametro("COMPRA", "CAMPO COMPRA", "CAMPO", true));
            parametros.add(new Parametro("DESCUENTO", "CAMPO DESCUENTO", "CAMPO", true));
            parametros.add(new Parametro("GARANTIA", "CAMPO GARANTIA", "CAMPO", true));
            parametros.add(new Parametro("TAMANO", "CAMPO TAMAÑO", "CAMPO", true));
            parametros.add(new Parametro("CARACTERISTICA", "CAMPO CARACTERISTICA", "CAMPO", true));
            parametros.add(new Parametro("TALLA", "CAMPO TALLA", "CAMPO", true));
            parametros.add(new Parametro("COLOR", "CAMPO COLOR", "CAMPO", true));
            parametros.add(new Parametro("MEMORIA", "CAMPO MEMORIA", "CAMPO", true));
            parametros.add(new Parametro("PROCESADOR", "CAMPO PROCESADOR", "CAMPO", true));
            parametros.add(new Parametro("CAMARA", "CAMPO CAMARA", "CAMPO", true));
            
            
            rep.saveAll(parametros);
        }
    }
}
