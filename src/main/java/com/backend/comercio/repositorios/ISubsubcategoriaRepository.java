package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.Subsubcategoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubsubcategoriaRepository extends JpaRepository<Subsubcategoria, Long>, JpaSpecificationExecutor<Subsubcategoria> {
	
	@Query(value = "select ss from Subsubcategoria ss "
            + " WHERE ss.subcategoria.id = :subcategoria_id")
    public List<Subsubcategoria> consultarPorSubcategoria(long subcategoria_id);
}
