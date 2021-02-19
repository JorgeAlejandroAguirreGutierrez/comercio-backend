package com.backend.comercio.servicios;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.comercio.exception.ModeloNoExistenteException;
import com.backend.comercio.modelos.Cliente;
import com.backend.comercio.modelos.Pedido;
import com.backend.comercio.repositorios.IClienteRepository;
import com.backend.comercio.repositorios.IPedidoRepository;
import com.backend.comercio.Constantes;
import com.backend.comercio.Util;

@Service
public class PedidoService {
	private static final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    private IPedidoRepository pedidoRepository;
    
    @Autowired
    private IClienteRepository clienteRepository;

    /**
     * Consulta la sesion por id
     * @param id
     * @return Sesion
     */
    public Optional<Pedido> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Pedido> pedido= pedidoRepository.findById(id);
        return pedido;
    }
    /**
     * Consulta todos los pedidos
     * @return List<Sesion>
     */
    public List<Pedido> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Pedido> pedidos= pedidoRepository.findAll();
        return pedidos;
    }
    /**
     * Crea un nuevo pedido
     * @param Pedido
     * @return Pedido 
     */
    public Optional<Pedido> crear(Pedido pedido) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	if(pedido.getCliente().getId()==0) {
    		pedido.setCliente(null);
    	}
    	long conteo=pedidoRepository.conteo();
    	pedido.setCodigo(Util.generarCodigo(Constantes.codigoPedido, conteo));
    	pedido.setFecha(new Date());
    	pedido.setConfirmar(false);
    	return Optional.of(pedidoRepository.save(pedido));
    }
    /**
     * Actualiza un pedido
     * @param Pedido
     * @return Pedido
     * @throws Exception 
     */
    public Optional<Pedido> actualizar(Pedido pedido) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(pedidoRepository.save(pedido));
    }
    
    /**
     * Elimina una sesion
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	pedidoRepository.deleteById(id);
    }
    
    /**
     * Actualiza la imagen de QR
     * @param id
     * @return Optional<Pedido>
     */
    public Optional<Pedido> actualizarQr(MultipartFile archivo, long id) throws Exception {
    	Optional<Pedido>pedido=pedidoRepository.findById(id);
    	String ruta=Constantes.guardarArchivo(archivo, id);
    	if(pedido.isPresent()) {
    		Pedido getPedido=pedido.get();
    		getPedido.setQr(ruta);
    		pedido=Optional.of(pedidoRepository.save(getPedido));
    		return pedido;
    	}
    	throw new ModeloNoExistenteException();	
    }
    
    /**
     * Obtiene el pedido de hoy por cliente 
     * @param celular
     * @return Optional<Pedido>
     */
    public List<Pedido> consultarPorCliente(String celular) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Pedido> pedido= pedidoRepository.consultarPorCliente(celular);
        return pedido;
    }
    

    /**
     * Obtiene el pedido de hoy por codigo 
     * @param codigo
     * @return Optional<Pedido>
     */
    public Optional<Pedido> obtenerPorCodigo(String codigo) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Pedido> pedido= pedidoRepository.obtenerPorCodigo(codigo);
        return pedido;
    }
    
    /**
     * Obtiene el pedido de hoy por codigo 
     * @param codigo
     * @return Optional<Pedido>
     */
    public Optional<Pedido> generar(Pedido _pedido) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Cliente> cliente= clienteRepository.obtenerPorCelular(_pedido.getCliente().getCelular());
        if(cliente.isPresent()) {
        	_pedido.setCliente(cliente.get());
        }
        if(!cliente.isPresent()) {
        	Cliente clienteNuevo=_pedido.getCliente();
        	Cliente clienteCreado= clienteRepository.save(clienteNuevo);
        	_pedido.setCliente(clienteCreado);
        }
        _pedido.setGenerar(true);
    	Pedido pedido=pedidoRepository.save(_pedido);
    	return Optional.of(pedido);
    }
    
    /**
     * Consulta por el estado del pedido
     * @param String estadoPedido
     * @return List<Pedido>
     */
    public List<Pedido> consultarPorEstadoPedido(String estadoPedido) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        if (estadoPedido.equals(Constantes.NO_CONFIRMADOS)) {
        	List<Pedido> pedido= pedidoRepository.consultarPorNoConfirmados();
            return pedido;
        }
        if (estadoPedido.equals(Constantes.NO_PAGADOS)) {
        	List<Pedido> pedido= pedidoRepository.consultarPorNoPagados();
            return pedido;
        }
        if (estadoPedido.equals(Constantes.NO_ENVIADOS)) {
        	List<Pedido> pedido= pedidoRepository.consultarPorNoEnviados();
            return pedido;
        }
    	return new ArrayList();
    }
}
