package com.backend.comercio.controladoras;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.comercio.modelos.Subcategoria;
import com.backend.comercio.servicios.SubcategoriaService;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;
import static com.backend.comercio.Constantes.SUBCATEGORIACONTROLLER;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping(SUBCATEGORIACONTROLLER)
@Validated
public class SubcategoriaController {
	private static final Logger logger = LoggerFactory.getLogger(SubcategoriaController.class);
	
    @Autowired
    private SubcategoriaService servicio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Subcategoria> subcategorias=servicio.consultar();
        return new ResponseEntity<>(subcategorias, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable("id") long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Subcategoria> subcategoria=servicio.obtener(id);
        return new ResponseEntity<>(subcategoria, HttpStatus.OK);
    }
    
    @GetMapping(value = "/consultarPorCategoria/{categoria_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultarPorCategoria(@PathVariable("categoria_id") long categoria_id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Subcategoria> subcategorias=servicio.consultarPorCategoria(categoria_id);
        return new ResponseEntity<>(subcategorias, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestBody @Valid Subcategoria _subcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Subcategoria> subcategoria=servicio.crear(_subcategoria);
        return new ResponseEntity<>(subcategoria, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizar(@RequestBody @Valid Subcategoria _subcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Subcategoria> subcategoria=servicio.actualizar(_subcategoria);
        return new ResponseEntity<>(subcategoria, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable("id") long id)  {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
