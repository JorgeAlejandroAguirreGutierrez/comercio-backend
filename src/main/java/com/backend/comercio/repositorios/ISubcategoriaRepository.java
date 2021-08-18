package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.Subcategoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubcategoriaRepository extends JpaRepository<Subcategoria, Long>, JpaSpecificationExecutor<Subcategoria> {
	
	@Query(value = "select s from Subcategoria s "
            + " WHERE s.categoria.id = :categoria_id")
    public List<Subcategoria> consultarPorCategoria(long categoria_id);
}
