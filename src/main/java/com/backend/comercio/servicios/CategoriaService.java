package com.backend.comercio.servicios;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;


import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.comercio.modelos.Categoria;
import com.backend.comercio.repositorios.ICategoriaRepository;

@Service
public class CategoriaService {
	private static final Logger logger = LoggerFactory.getLogger(CategoriaService.class);

    @Autowired
    private ICategoriaRepository categoriaRepository;

    /**
     * Consulta el producto por id
     * @param id
     * @return Producto
     */
    public Optional<Categoria> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Categoria> producto= categoriaRepository.findById(id);
        return producto;
    }
    /**
     * Consulta todos los productos
     * @return List<Producto>
     */
    public List<Categoria> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Categoria> productos = categoriaRepository.findAll();
        return productos;
    }
    /**
     * Crea un nuevo producto
     * @param Producto
     * @return Producto 
     */
    public Optional<Categoria> crear(Categoria categoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(categoriaRepository.save(categoria));
    }
    /**
     * Actualiza un producto
     * @param Producto
     * @return Producto
     */
    public Optional<Categoria> actualizar(Categoria categoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(categoriaRepository.save(categoria));
    }
    
    /**
     * Elimina un producto
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	categoriaRepository.deleteById(id);
    }
    
    /**
     * Consulta los productos por nombre
     * @return List<Producto>
     */
    public List<Categoria> buscar(Categoria categoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  categoriaRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    if (categoria.getDescripcion()!=null) {
		        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("descripcion"), "%"+categoria.getDescripcion()+"%")));
		    }
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
}
