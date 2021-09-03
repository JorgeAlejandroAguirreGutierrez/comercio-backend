package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.Categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long>, JpaSpecificationExecutor<Categoria> {
	
	@Query(value = "select c from Categoria c JOIN c.subcategorias s JOIN s.subsubcategorias ss "
            + "WHERE c.descripcion= :categoria AND s.descripcion= :subcategoria AND ss.descripcion= :subsubcategoria")
    public List<Categoria> buscar(String categoria, String subcategoria, String subsubcategoria);
	
	@Query(value = "select c from Categoria c "
            + "WHERE c.descripcion= :categoria")
    public Optional<Categoria> obtenerPorDescripcion(String categoria);
	
	@Query("select c from Categoria c JOIN c.subcategorias s JOIN s.subsubcategorias ss "
			+ "WHERE c.descripcion=:categoria AND s.descripcion=:subcategoria AND ss.descripcion=:subsubcategoria")
	Optional<Categoria> obtenerPorCategoriaSubcategoriaSubsubcategoria(String categoria, String subcategoria, String subsubcategoria);
	
	@Query("select c from Categoria c JOIN c.subcategorias s JOIN s.subsubcategorias ss "
			+ "WHERE c.descripcion=:categoria AND s.descripcion=:subcategoria AND ss.descripcion=:subsubcategoria")
	Optional<Categoria> obtenerPorCategoriaSubcategoriaSubcategoria(String categoria, String subcategoria, String subsubcategoria);
	
	@Transactional
	@Modifying
	@Query("delete from Categoria c "
			+ "WHERE c.descripcion=:categoria")
	void eliminar(String categoria);
}
