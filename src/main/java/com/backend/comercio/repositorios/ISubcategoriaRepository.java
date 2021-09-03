package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.Subcategoria;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ISubcategoriaRepository extends JpaRepository<Subcategoria, Long>, JpaSpecificationExecutor<Subcategoria> {
	
	@Query(value = "select s from Subcategoria s "
            + " WHERE s.categoria.id = :categoria_id")
    public List<Subcategoria> consultarPorCategoria(long categoria_id);
	
	@Query(value = "select s from Subcategoria s "
            + " WHERE s.descripcion= :subcategoria")
    public Optional<Subcategoria> obtenerPorDescripcion(String subcategoria);
	
	@Transactional
	@Modifying
	@Query("delete from Subcategoria s "
			+ "WHERE s.descripcion=:subcategoria")
	void eliminar(String subcategoria);
}
