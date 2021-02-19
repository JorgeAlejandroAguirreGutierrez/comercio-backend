package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.Cliente;
import com.backend.comercio.modelos.Parametro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IParametroRepository extends JpaRepository<Parametro, Long>, JpaSpecificationExecutor<Parametro> {

	@Query(value="select p from Parametro p "  
			+" WHERE p.tipo=:tipo")
	public List<Cliente> consultarPorTipo(String tipo);
}
