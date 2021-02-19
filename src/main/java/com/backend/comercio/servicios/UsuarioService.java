package com.backend.comercio.servicios;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.comercio.modelos.Usuario;
import com.backend.comercio.repositorios.IUsuarioRepository;

@Service
public class UsuarioService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private IUsuarioRepository usuarioRepository;

    /**
     * Obtiene el usuario por id
     * @param id
     * @return Usuario
     */
    public Optional<Usuario> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Usuario> usuario= usuarioRepository.findById(id);
        return usuario;
    }
    /**
     * Consulta todos los usuarios
     * @return List<Usuario>
     */
    public List<Usuario> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }
    /**
     * Crea un nuevo usuario
     * @param Usuario
     * @return Usuario 
     */
    public Optional<Usuario> crear(Usuario usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(usuarioRepository.save(usuario));
    }
    /**
     * Actualiza un usuario
     * @param Usuario
     * @return Usuario
     */
    public Optional<Usuario> actualizar(Usuario usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(usuarioRepository.save(usuario));
    }
    
    /**
     * Elimina un usuario
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	usuarioRepository.deleteById(id);
    }
    
    /**
     * Metodo que permite buscar un usuario por nombre y contrasena
     * @param Usuario
     * @return Usuario
     */
    public Optional<Usuario> buscarIdentificacionContrasena(Usuario usuario){
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return usuarioRepository.buscarIdentificacionContrasena(usuario.getNombre(), usuario.getContrasena());
    }
}


