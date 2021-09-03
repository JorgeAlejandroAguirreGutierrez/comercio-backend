package com.backend.comercio.servicios;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.comercio.modelos.Categoria;
import com.backend.comercio.repositorios.ICategoriaRepository;
import com.backend.comercio.repositorios.ISubcategoriaRepository;
import com.backend.comercio.repositorios.ISubsubcategoriaRepository;

@Service
public class CategoriaService {
	private static final Logger logger = LoggerFactory.getLogger(CategoriaService.class);

    @Autowired
    private ICategoriaRepository categoriaRepository;
    
    @Autowired
    private ISubcategoriaRepository subcategoriaRepository;
    
    @Autowired
    private ISubsubcategoriaRepository subsubcategoriaRepository;

    /**
     * Consulta la categoria por id
     * @param id
     * @return Categoria
     */
    public Optional<Categoria> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Categoria> producto= categoriaRepository.findById(id);
        return producto;
    }
    /**
     * Consulta todos las categorias
     * @return List<Categoria>
     */
    public List<Categoria> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Categoria> productos = categoriaRepository.findAll();
        return productos;
    }
    /**
     * Crea una nueva categoria
     * @param Categoria
     * @return Categoria 
     */
    public Optional<Categoria> crear(Categoria categoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(categoriaRepository.save(categoria));
    }
    /**
     * Actualiza una categoria
     * @param Categoria
     * @return Categoria
     */
    public Optional<Categoria> actualizar(Categoria categoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(categoriaRepository.save(categoria));
    }
    
    /**
     * Elimina una categoria
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	categoriaRepository.deleteById(id);
    }
    
    /**
     * Buscar por categoria, subcategoria y subsubcategoria
     * @return List<Categoria>
     */
    public List<Categoria> buscar(String categoria, String subcategoria, String subsubcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Categoria> categorias = categoriaRepository.buscar(categoria, subcategoria, subsubcategoria);
        return categorias;
    }
    
    /**
     * Eliminar por categoria, subcategoria y subsubcategoria
     * @return
     */
    public void eliminarPorCategoriaSubcategoriaSubsubcategoria(String categoria, String subcategoria, String subsubcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
		if(!subsubcategoria.isEmpty()) {
			subsubcategoriaRepository.eliminar(subsubcategoria);
		} else if(!subcategoria.isEmpty()) {
			subcategoriaRepository.eliminar(subcategoria);
		} else {
			categoriaRepository.eliminar(categoria);
		}
    }
}
