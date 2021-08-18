package com.backend.comercio.servicios;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.comercio.modelos.Subsubcategoria;
import com.backend.comercio.repositorios.ISubsubcategoriaRepository;

@Service
public class SubsubcategoriaService {
	private static final Logger logger = LoggerFactory.getLogger(SubsubcategoriaService.class);

    @Autowired
    private ISubsubcategoriaRepository subsubcategoriaRepository;

    /**
     * Consulta la subsubcategoria por id
     * @param id
     * @return Subsubcategoria
     */
    public Optional<Subsubcategoria> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Subsubcategoria> subsubcategoria= subsubcategoriaRepository.findById(id);
        return subsubcategoria;
    }
    /**
     * Consulta todos las subsubcategorias
     * @return List<Subsubcategoria>
     */
    public List<Subsubcategoria> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Subsubcategoria> subsubcategorias = subsubcategoriaRepository.findAll();
        return subsubcategorias;
    }
    
    /**
     * Consulta las subsubcategorias deacuerdo a una subcategoria
     * @return List<Subcategoria>
     */
    public List<Subsubcategoria> consultarPorSubcategoria(long subcategoria_id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Subsubcategoria> subsubcategorias = subsubcategoriaRepository.consultarPorSubcategoria(subcategoria_id);
        return subsubcategorias;
    }
    /**
     * Crea una nueva subsubcategoria
     * @param Subcategoria
     * @return Subsubcategoria 
     */
    public Optional<Subsubcategoria> crear(Subsubcategoria subsubcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(subsubcategoriaRepository.save(subsubcategoria));
    }
    /**
     * Actualiza una subsubcategoria
     * @param Subsubcategoria
     * @return Subsubcategoria
     */
    public Optional<Subsubcategoria> actualizar(Subsubcategoria subsubcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(subsubcategoriaRepository.save(subsubcategoria));
    }
    
    /**
     * Elimina una subsubcategoria
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	subsubcategoriaRepository.deleteById(id);
    }
}
