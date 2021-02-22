package com.backend.comercio.servicios;

import static com.backend.comercio.Constantes.LOGCLASS;
import static com.backend.comercio.Constantes.LOGMETHOD;


import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.comercio.Constantes;
import com.backend.comercio.exception.ModeloNoExistenteException;
import com.backend.comercio.modelos.Imagen;
import com.backend.comercio.modelos.Producto;
import com.backend.comercio.repositorios.IProductoRepository;

@Service
public class ProductoService {
	private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private IProductoRepository productoRepository;

    /**
     * Consulta el producto por id
     * @param id
     * @return Producto
     */
    public Optional<Producto> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Producto> producto= productoRepository.findById(id);
        return producto;
    }
    /**
     * Consulta todos los productos
     * @return List<Producto>
     */
    public List<Producto> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Producto> productos = productoRepository.findAll();
        return productos;
    }
    /**
     * Crea un nuevo producto
     * @param Producto
     * @return Producto 
     */
    public Optional<Producto> crear(Producto producto) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	producto.setDisponible(true);
    	return Optional.of(productoRepository.save(producto));
    }
    /**
     * Actualiza un producto
     * @param Producto
     * @return Producto
     */
    public Optional<Producto> actualizar(Producto producto) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(productoRepository.save(producto));
    }
    
    /**
     * Elimina un producto
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	productoRepository.deleteById(id);
    }
    
    public boolean imagen(MultipartFile archivo, long id) throws Exception {
    	Optional<Producto>producto=productoRepository.findById(id);
    	String ruta=Constantes.guardarArchivo(archivo, id);
    	if(producto.isPresent()) {
    		Producto getProducto=producto.get();
    		Imagen imagen= new Imagen();
    		imagen.setRuta(ruta);
    		getProducto.getImagenes().add(imagen);
    		productoRepository.save(getProducto);
    		return true;
    	}
    	throw new ModeloNoExistenteException();	
    }
    
    /**
     * Consulta los productos por nombre
     * @return List<Producto>
     */
    public List<Producto> buscar(Producto producto) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  productoRepository.findAll(new Specification<Producto>() {
            @Override
            public Predicate toPredicate(Root<Producto> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (producto.getMarca()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("marca"), "%"+producto.getMarca()+"%")));
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("disponible"), true)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }
    
    /**
     * Consulta los productos por nombre
     * @return List<Producto>
     */
    public List<Producto> consultarPorCategoria(String categoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  productoRepository.findAll(new Specification<Producto>() {
            @Override
            public Predicate toPredicate(Root<Producto> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (categoria!=null && !categoria.equals("")) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("categoria"), categoria)));
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("disponible"), true)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }
    
    /**
     * Consulta los productos por marca, categoria y subcategoria
     * @return List<Producto>
     */
    public List<Producto> consultarPorMarcaCategoriaSubcategoria(String marca, String categoria, String subcategoria) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  productoRepository.findAll(new Specification<Producto>() {
            @Override
            public Predicate toPredicate(Root<Producto> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (marca!=null && !marca.equals("")) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("marca"), "%"+marca+"%")));
                }
                if (categoria!=null && !categoria.equals("")) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("categoria"), categoria)));  
                }
                if (subcategoria!=null && !subcategoria.equals("")) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("subcategoria"), subcategoria)));
                }
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("disponible"), true)));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }
    
    /**
     * Consulta los productos por nombre
     * @return List<Producto>
     */
    public Optional<Producto> disponible(Producto producto) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	if (producto.isDisponible()) {
    		producto.setDisponible(false);
    	} else {
    		producto.setDisponible(true);
    	}
    	Optional<Producto>_producto=Optional.of(productoRepository.save(producto));
    	return _producto;
    }
}
