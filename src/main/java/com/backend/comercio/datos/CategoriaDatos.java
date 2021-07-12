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

import com.backend.comercio.modelos.Categoria;
import com.backend.comercio.modelos.Subcategoria;
import com.backend.comercio.repositorios.ICategoriaRepository;

@Component
@Order(2)
@Profile({"dev","prod"})
public class CategoriaDatos implements ApplicationRunner {
	@Autowired
    private ICategoriaRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Categoria> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<Categoria> categorias= new ArrayList<>();
            //CATEGORIAS
            List<Subcategoria> subcategorias=new ArrayList<>();
            subcategorias.add(new Subcategoria("TENIS"));
            subcategorias.add(new Subcategoria("ZAPATILLAS"));
            subcategorias.add(new Subcategoria("MOCASIN"));
            categorias.add(new Categoria("ZAPATOS", subcategorias));
            
            subcategorias=new ArrayList<>();
            subcategorias.add(new Subcategoria("ELEGANTE"));
            subcategorias.add(new Subcategoria("CASUAL"));
            subcategorias.add(new Subcategoria("DEPORTIVO"));
            categorias.add(new Categoria("BOLSOS", subcategorias));
            
            subcategorias=new ArrayList<>();
            subcategorias.add(new Subcategoria("DEPORTIVO"));
            categorias.add(new Categoria("TRAJES DEPORTIVOS", subcategorias));
            
            rep.saveAll(categorias);
        }
    }
}
