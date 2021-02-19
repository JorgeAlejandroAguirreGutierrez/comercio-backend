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
            parametros.add(new Parametro("ZAPATOS", "CATEGORIA", true));
            parametros.add(new Parametro("BOLSOS", "CATEGORIA", true));
            parametros.add(new Parametro("TRAJES DEPORTIVOS", "CATEGORIA", true));
            
            //ESTILOS
            parametros.add(new Parametro("TENIS", "ESTILO", true));
            parametros.add(new Parametro("ZAPATILLAS", "ESTILO", true));
            parametros.add(new Parametro("MOCASIN", "ESTILO", true));
            parametros.add(new Parametro("TENIS TACON", "ESTILO", true));
            parametros.add(new Parametro("TACON", "ESTILO", true));
            parametros.add(new Parametro("SANDALIAS", "ESTILO", true));
            parametros.add(new Parametro("CHANCLAS", "ESTILO", true));
            parametros.add(new Parametro("BOTAS", "ESTILO", true));
            parametros.add(new Parametro("BOTINES", "ESTILO", true));
            parametros.add(new Parametro("BALETAS", "ESTILO", true));
            parametros.add(new Parametro("TRACTOR", "ESTILO", true));
            
            //TALLAS
            parametros.add(new Parametro("21", "TALLA", true));
            parametros.add(new Parametro("22", "TALLA", true));
            parametros.add(new Parametro("23", "TALLA", true));
            parametros.add(new Parametro("24", "TALLA", true));
            parametros.add(new Parametro("25", "TALLA", true));
            parametros.add(new Parametro("26", "TALLA", true));
            parametros.add(new Parametro("27", "TALLA", true));
            parametros.add(new Parametro("28", "TALLA", true));
            parametros.add(new Parametro("29", "TALLA", true));
            parametros.add(new Parametro("30", "TALLA", true));
            parametros.add(new Parametro("31", "TALLA", true));
            parametros.add(new Parametro("32", "TALLA", true));
            parametros.add(new Parametro("33", "TALLA", true));
            parametros.add(new Parametro("34", "TALLA", true));
            parametros.add(new Parametro("35", "TALLA", true));
            parametros.add(new Parametro("36", "TALLA", true));
            parametros.add(new Parametro("37", "TALLA", true));
            parametros.add(new Parametro("38", "TALLA", true));
            parametros.add(new Parametro("39", "TALLA", true));
            parametros.add(new Parametro("40", "TALLA", true));
            parametros.add(new Parametro("41", "TALLA", true));
            parametros.add(new Parametro("42", "TALLA", true));
            parametros.add(new Parametro("43", "TALLA", true));
            
            //COLORES
            parametros.add(new Parametro("NEGRO", "COLOR", true));
            parametros.add(new Parametro("ROJO", "COLOR", true));
            parametros.add(new Parametro("BLANCO", "COLOR", true));
            parametros.add(new Parametro("AZUL", "COLOR", true));
            parametros.add(new Parametro("GRIS", "COLOR", true));
            parametros.add(new Parametro("BEIGE", "COLOR", true));
            parametros.add(new Parametro("VERDE", "COLOR", true));
            parametros.add(new Parametro("AMARILLO", "COLOR", true));
            parametros.add(new Parametro("NARANJA", "COLOR", true));
            parametros.add(new Parametro("CAFE", "COLOR", true));
            parametros.add(new Parametro("DORADO", "COLOR", true));
            parametros.add(new Parametro("PLATEADO", "COLOR", true));
            parametros.add(new Parametro("AGUMARINA", "COLOR", true));
            parametros.add(new Parametro("ROSADO", "COLOR", true));
            parametros.add(new Parametro("FUCSIA", "COLOR", true));
            parametros.add(new Parametro("VERDEFOSFORECENTE", "COLOR", true));
            parametros.add(new Parametro("CIELO", "COLOR", true));
            parametros.add(new Parametro("CHOCOLATE", "COLOR", true));
            parametros.add(new Parametro("SALMON", "COLOR", true));
            
            parametros.add(new Parametro("NO CONFIRMADOS", "ESTADO_PEDIDO", true));
            parametros.add(new Parametro("NO PAGADOS", "ESTADO_PEDIDO", true));
            parametros.add(new Parametro("NO ENVIADOS", "ESTADO_PEDIDO", true));
            
            rep.saveAll(parametros);
        }
    }
}
