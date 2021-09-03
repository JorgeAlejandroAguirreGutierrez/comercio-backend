package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.Subsubcategoria;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ISubsubcategoriaRepository extends JpaRepository<Subsubcategoria, Long>, JpaSpecificationExecutor<Subsubcategoria> {
	
	@Query(value = "select ss from Subsubcategoria ss "
            + " WHERE ss.subcategoria.id = :subcategoria_id")
    public List<Subsubcategoria> consultarPorSubcategoria(long subcategoria_id);
	
	@Query(value = "select ss from Subsubcategoria ss "
            + " WHERE ss.descripcion= :subsubcategoria")
    public Optional<Subsubcategoria> obtenerPorDescripcion(String subsubcategoria);
	
	@Transactional
	@Modifying
	@Query("delete from Subsubcategoria ss "
			+ "WHERE ss.descripcion=:subsubcategoria")
	void eliminar(String subsubcategoria);
}
