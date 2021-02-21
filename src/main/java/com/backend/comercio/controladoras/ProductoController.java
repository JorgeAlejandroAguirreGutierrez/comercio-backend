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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.comercio.modelos.Producto;
import com.backend.comercio.servicios.ProductoService;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;
import static com.backend.comercio.Constantes.PRODUCTOCONTROLLER;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping(PRODUCTOCONTROLLER)
@Validated
public class ProductoController {
	private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);
	
    @Autowired
    private ProductoService servicio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Producto> productos=servicio.consultar();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable("id") long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Producto> producto=servicio.obtener(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestBody @Valid Producto _producto) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Producto> producto=servicio.crear(_producto);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizar(@RequestBody @Valid Producto _producto) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Producto> producto=servicio.actualizar(_producto);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable("id") long id)  {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(value = "/imagen/{id}", headers = "content-type=multipart/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> imagen(@RequestPart("imagen") MultipartFile imagen, @PathVariable("id") long id ) throws Exception {
        boolean bandera=servicio.imagen(imagen, id);
        return new ResponseEntity<>(bandera, HttpStatus.OK);
    }
    
    @PostMapping(value="/buscar",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscar(@RequestBody Producto _producto) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Producto> productos=servicio.buscar(_producto);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    
    @GetMapping(value = "/consultarPorCategoria/{categoria}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable("categoria") String categoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Producto> producto=servicio.consultarPorCategoria(categoria);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/consultarPorMarcaCategoriaSubcategoria/{marca}/{categoria}/{subcategoria}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable("marca") String marca, @PathVariable("categoria") String categoria, @PathVariable("subcategoria") String subcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Producto> producto=servicio.consultarPorMarcaCategoriaSubcategoria(marca, categoria, subcategoria);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/disponible", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@RequestBody Producto producto) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Producto> _producto=servicio.disponible(producto);
        return new ResponseEntity<>(_producto, HttpStatus.OK);
    }
}
