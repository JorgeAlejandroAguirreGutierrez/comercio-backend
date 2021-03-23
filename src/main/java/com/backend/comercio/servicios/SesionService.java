package com.backend.comercio.servicios;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.comercio.exception.ModeloNoExistenteException;
import com.backend.comercio.exception.SesionInvalidaException;
import com.backend.comercio.modelos.Sesion;
import com.backend.comercio.modelos.Usuario;
import com.backend.comercio.repositorios.ISesionRepository;
import com.backend.comercio.repositorios.IUsuarioRepository;

@Service
public class SesionService {
	private static final Logger logger = LoggerFactory.getLogger(SesionService.class);

    @Autowired
    private ISesionRepository sesionRepository;
    
    @Autowired
    private IUsuarioRepository usuarioRepository;

    /**
     * Consulta la sesion por id
     * @param id
     * @return Sesion
     */
    public Optional<Sesion> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Sesion> sesion= sesionRepository.findById(id);
        return sesion;
    }
    /**
     * Consulta todas las sesiones
     * @return List<Sesion>
     */
    public List<Sesion> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Sesion> sesiones= sesionRepository.findAll();
        return sesiones;
    }
    /**
     * Crea una nueva sesion
     * @param Sesion
     * @return Sesion 
     */
    public Optional<Sesion> crear(Sesion sesion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	Optional<Usuario> usuario=usuarioRepository.buscarIdentificacionContrasena(sesion.getUsuario().getIdentificacion(), sesion.getUsuario().getContrasena());
    	if(usuario.isPresent()) {
    		sesion.setUsuario(usuario.get());
    		return Optional.of(sesionRepository.save(sesion));
    	}
    	throw new ModeloNoExistenteException();
    }
    /**
     * Actualiza una sesion
     * @param Sesion
     * @return Sesion
     */
    public Optional<Sesion> actualizar(Sesion sesion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(sesionRepository.save(sesion));
    }
    
    /**
     * Elimina una sesion
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	sesionRepository.deleteById(id);
    }
    
    /**
     * Valida la sesion del usuario por id
     * @param id
     * @return Sesion
     */
    public Optional<Sesion> validar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Sesion> sesion= sesionRepository.findById(id);
        if (sesion.isPresent()) {
        	long startTime = sesion.get().getFechaApertura().getTime();
			long endTime = new Date().getTime();
			long diffTime = endTime - startTime;
			long diffDays = diffTime / (1000 * 60 * 60 * 24);
			if(diffDays<1) {
				return sesion;
			}
			throw new SesionInvalidaException();
        }
        throw new ModeloNoExistenteException();
    }
}
