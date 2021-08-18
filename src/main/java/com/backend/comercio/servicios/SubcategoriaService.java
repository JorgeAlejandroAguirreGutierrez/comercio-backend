package com.backend.comercio.servicios;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.comercio.modelos.Subcategoria;
import com.backend.comercio.repositorios.ISubcategoriaRepository;

@Service
public class SubcategoriaService {
	private static final Logger logger = LoggerFactory.getLogger(SubcategoriaService.class);

    @Autowired
    private ISubcategoriaRepository subcategoriaRepository;

    /**
     * Consulta la subcategoria por id
     * @param id
     * @return Subcategoria
     */
    public Optional<Subcategoria> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Subcategoria> subcategoria= subcategoriaRepository.findById(id);
        return subcategoria;
    }
    /**
     * Consulta todos las subcategorias
     * @return List<Subcategoria>
     */
    public List<Subcategoria> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Subcategoria> subcategorias = subcategoriaRepository.findAll();
        return subcategorias;
    }
    
    /**
     * Consulta las subcategorias deacuerdo a una categoria
     * @return List<Subcategoria>
     */
    public List<Subcategoria> consultarPorCategoria(long categoria_id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Subcategoria> subcategorias = subcategoriaRepository.consultarPorCategoria(categoria_id);
        return subcategorias;
    }
    /**
     * Crea una nueva subcategoria
     * @param Subcategoria
     * @return Subcategoria 
     */
    public Optional<Subcategoria> crear(Subcategoria subcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(subcategoriaRepository.save(subcategoria));
    }
    /**
     * Actualiza una subcategoria
     * @param Subcategoria
     * @return Subcategoria
     */
    public Optional<Subcategoria> actualizar(Subcategoria subcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(subcategoriaRepository.save(subcategoria));
    }
    
    /**
     * Elimina una subcategoria
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	subcategoriaRepository.deleteById(id);
    }
}
