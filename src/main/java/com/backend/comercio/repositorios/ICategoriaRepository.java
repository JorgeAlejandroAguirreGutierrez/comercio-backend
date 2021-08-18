package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.Categoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long>, JpaSpecificationExecutor<Categoria> {
	
	@Query(value = "select c from Categoria c JOIN c.subcategorias s JOIN s.subsubcategorias ss "
            + " WHERE c.descripcion= :categoria AND s.descripcion= :subcategoria AND ss.descripcion= :subsubcategoria")
    public List<Categoria> buscar(String categoria, String subcategoria, String subsubcategoria);
}
