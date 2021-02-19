package com.backend.comercio.controladoras;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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

import com.backend.comercio.modelos.Pedido;
import com.backend.comercio.servicios.PedidoService;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;
import static com.backend.comercio.Constantes.PEDIDOCONTROLLER;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping(PEDIDOCONTROLLER)
@Validated
public class PedidoController {
	private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);
	
    @Autowired
    private PedidoService servicio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Pedido> pedidos=servicio.consultar();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable("id") long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Pedido> pedido=servicio.obtener(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestBody @Valid Pedido _pedido) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Pedido> pedido=servicio.crear(_pedido);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizar(@RequestBody @Valid Pedido _pedido) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Pedido> pedido=servicio.actualizar(_pedido);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable("id") long id)  {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(value = "/qr/{id}", headers = "content-type=multipart/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizarQr(@RequestPart("qr") MultipartFile imagen, @PathVariable("id") long id ) throws Exception {
        Optional<Pedido> pedido=servicio.actualizarQr(imagen, id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
    
    @GetMapping(value = "/consultarporcliente/{celular}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerPorCliente(@PathVariable("celular") String celular) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Pedido> pedidos=servicio.consultarPorCliente(celular);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
    
    @GetMapping(value = "/obtenerporcodigo/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerPorCodigo(@PathVariable("codigo") String codigo) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Pedido> pedido=servicio.obtenerPorCodigo(codigo);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
    
    @PutMapping(value = "/generar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerPorCodigo(@RequestBody @Valid Pedido _pedido) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Pedido> pedido=servicio.generar(_pedido);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
    
    @GetMapping(value = "/consultarporestadopedido/{estadopedido}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultarPorEstadoPedido(@PathVariable("estadopedido") String estadoPedido) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Pedido> pedidos=servicio.consultarPorEstadoPedido(estadoPedido);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
}
