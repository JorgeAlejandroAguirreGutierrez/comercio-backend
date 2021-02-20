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
            //CATEGORIAS
            parametros.add(new Parametro(null, "ZAPATOS", "CATEGORIA", true));
            parametros.add(new Parametro(null, "BOLSOS", "CATEGORIA", true));
            parametros.add(new Parametro(null, "TRAJES DEPORTIVOS", "CATEGORIA", true));
            
            //ESTILOS
            parametros.add(new Parametro(null, "TENIS", "ESTILO", true));
            parametros.add(new Parametro(null, "ZAPATILLAS", "ESTILO", true));
            parametros.add(new Parametro(null, "MOCASIN", "ESTILO", true));
            parametros.add(new Parametro(null, "TENIS TACON", "ESTILO", true));
            parametros.add(new Parametro(null, "TACON", "ESTILO", true));
            parametros.add(new Parametro(null, "SANDALIAS", "ESTILO", true));
            parametros.add(new Parametro(null, "CHANCLAS", "ESTILO", true));
            parametros.add(new Parametro(null, "BOTAS", "ESTILO", true));
            parametros.add(new Parametro(null, "BOTINES", "ESTILO", true));
            parametros.add(new Parametro(null, "BALETAS", "ESTILO", true));
            parametros.add(new Parametro(null, "TRACTOR", "ESTILO", true));
            
            //TALLAS
            parametros.add(new Parametro(null, "21", "TALLA", true));
            parametros.add(new Parametro(null, "22", "TALLA", true));
            parametros.add(new Parametro(null, "23", "TALLA", true));
            parametros.add(new Parametro(null, "24", "TALLA", true));
            parametros.add(new Parametro(null, "25", "TALLA", true));
            parametros.add(new Parametro(null, "26", "TALLA", true));
            parametros.add(new Parametro(null, "27", "TALLA", true));
            parametros.add(new Parametro(null, "28", "TALLA", true));
            parametros.add(new Parametro(null, "29", "TALLA", true));
            parametros.add(new Parametro(null, "30", "TALLA", true));
            parametros.add(new Parametro(null, "31", "TALLA", true));
            parametros.add(new Parametro(null, "32", "TALLA", true));
            parametros.add(new Parametro(null, "33", "TALLA", true));
            parametros.add(new Parametro(null, "34", "TALLA", true));
            parametros.add(new Parametro(null, "35", "TALLA", true));
            parametros.add(new Parametro(null, "36", "TALLA", true));
            parametros.add(new Parametro(null, "37", "TALLA", true));
            parametros.add(new Parametro(null, "38", "TALLA", true));
            parametros.add(new Parametro(null, "39", "TALLA", true));
            parametros.add(new Parametro(null, "40", "TALLA", true));
            parametros.add(new Parametro(null, "41", "TALLA", true));
            parametros.add(new Parametro(null, "42", "TALLA", true));
            parametros.add(new Parametro(null, "43", "TALLA", true));
            
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
            parametros.add(new Parametro(null, "NO CONFIRMADOS", "ESTADO_PEDIDO", true));
            parametros.add(new Parametro(null, "NO PAGADOS", "ESTADO_PEDIDO", true));
            parametros.add(new Parametro(null, "NO ENVIADOS", "ESTADO_PEDIDO", true));
            
            parametros.add(new Parametro("DAVIVIENDA", "AL NUMERO DE CUENTA: 018000456321", "MEDIO_PAGO", true));
            parametros.add(new Parametro("BANCOLOMBIA", "AL NUMERO DE CUENTA: 017000852146", "MEDIO_PAGO", true));
            parametros.add(new Parametro("DAVIPLATA", "AL NUMERO DE CELULAR: 3113395701", "MEDIO_PAGO", true));
            parametros.add(new Parametro("EFECTY", "AL NUMERO DE CEDULA: 1053847607", "MEDIO_PAGO", true));
            rep.saveAll(parametros);
        }
    }
}
