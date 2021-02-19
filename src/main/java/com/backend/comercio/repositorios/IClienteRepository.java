package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

	@Query(value="select c from Cliente c "  
			+" WHERE c.celular=:celular")
	public Optional<Cliente> obtenerPorCelular(String celular);
}
