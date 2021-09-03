package com.backend.comercio.servicios;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.comercio.modelos.Detalle;
import com.backend.comercio.repositorios.IDetalleRepository;

@Service
public class DetalleService {
	private static final Logger logger = LoggerFactory.getLogger(DetalleService.class);

    @Autowired
    private IDetalleRepository detalleRepository;

    /**
     * Consulta el detalle por id
     * @param id
     * @return Detalle
     */
    public Optional<Detalle> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Detalle> detalle= detalleRepository.findById(id);
        return detalle;
    }
    /**
     * Consulta todos los detalles
     * @return List<Detalle>
     */
    public List<Detalle> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Detalle> detalles= detalleRepository.findAll();
        return detalles;
    }
    /**
     * Crea un nuevo detalle
     * @param Detalle
     * @return Detalle 
     */
    public Optional<Detalle> crear(Detalle detalle) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(detalleRepository.save(detalle));
    }
    /**
     * Actualiza un detalle
     * @param Detalle
     * @return Detalle
     */
    public Optional<Detalle> actualizar(Detalle detalle) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(detalleRepository.save(detalle));
    }
    
    /**
     * Elimina un detalle
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	detalleRepository.deleteById(id);
    }
}
