package com.backend.comercio.servicios;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.comercio.modelos.Cliente;
import com.backend.comercio.repositorios.IClienteRepository;

@Service
public class ClienteService {
	private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private IClienteRepository clienteRepository;

    /**
     * Consulta el cliente por id
     * @param id
     * @return Cliente
     */
    public Optional<Cliente> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Cliente> cliente= clienteRepository.findById(id);
        return cliente;
    }
    /**
     * Consulta todos los clientes
     * @return List<Cliente>
     */
    public List<Cliente> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Cliente> clientes= clienteRepository.findAll();
        return clientes;
    }
    /**
     * Crea un nuevo cliente
     * @param Cliente
     * @return Cliente 
     */
    public Optional<Cliente> crear(Cliente cliente) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	Optional<Cliente>_cliente=clienteRepository.obtenerPorCelular(cliente.getCelular());
    	if(_cliente.isPresent()) {
    		return _cliente;
    	}
    	return Optional.of(clienteRepository.save(cliente));
    }
    /**
     * Actualiza un cliente
     * @param Cliente
     * @return Cliente
     */
    public Optional<Cliente> actualizar(Cliente cliente) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(clienteRepository.save(cliente));
    }
    
    /**
     * Elimina un cliente
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	clienteRepository.deleteById(id);
    }
    
    /**
     * obtiene el cliente por celular
     * @param id
     * @return Cliente
     */
    public Optional<Cliente> obtenerPorCelular(String celular) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Cliente> cliente= clienteRepository.obtenerPorCelular(celular);
        return cliente;
    }
}
