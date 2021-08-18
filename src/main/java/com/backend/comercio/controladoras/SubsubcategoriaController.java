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
import com.backend.comercio.modelos.Subsubcategoria;
import com.backend.comercio.servicios.SubsubcategoriaService;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;
import static com.backend.comercio.Constantes.SUBSUBCATEGORIACONTROLLER;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping(SUBSUBCATEGORIACONTROLLER)
@Validated
public class SubsubcategoriaController {
	private static final Logger logger = LoggerFactory.getLogger(SubsubcategoriaController.class);
	
    @Autowired
    private SubsubcategoriaService servicio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Subsubcategoria> subsubcategorias=servicio.consultar();
        return new ResponseEntity<>(subsubcategorias, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable("id") long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Subsubcategoria> subsubcategoria=servicio.obtener(id);
        return new ResponseEntity<>(subsubcategoria, HttpStatus.OK);
    }
    
    @GetMapping(value = "/consultarPorSubcategoria/{subcategoria_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultarPorCategoria(@PathVariable("subcategoria_id") long subcategoria_id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Subsubcategoria> subsubcategorias=servicio.consultarPorSubcategoria(subcategoria_id);
        return new ResponseEntity<>(subsubcategorias, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestBody @Valid Subsubcategoria _subsubcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Subsubcategoria> subsubcategoria=servicio.crear(_subsubcategoria);
        return new ResponseEntity<>(subsubcategoria, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizar(@RequestBody @Valid Subsubcategoria _subsubcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Subsubcategoria> subsubcategoria=servicio.actualizar(_subsubcategoria);
        return new ResponseEntity<>(subsubcategoria, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable("id") long id)  {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
