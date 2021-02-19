package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.Pedido;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Long>, JpaSpecificationExecutor<Pedido> {
	@Query(value="select p from Pedido p JOIN p.cliente c"  
			+" WHERE c.celular=:celular")
	public List<Pedido> consultarPorCliente(String celular);
	
	@Query(value="select p from Pedido p"  
			+" WHERE p.codigo=:codigo")
	public Optional<Pedido> obtenerPorCodigo(String codigo);
	
	@Query(value = "SELECT count(*) FROM pedido", nativeQuery = true)
    long conteo();
	
	@Query(value="select p from Pedido p"  
			+" WHERE p.confirmar=false")
	public List<Pedido> consultarPorNoConfirmados();
	
	@Query(value="select p from Pedido p"  
			+" WHERE p.pagado=false")
	public List<Pedido> consultarPorNoPagados();
	
	@Query(value="select p from Pedido p"  
			+" WHERE p.enviado=false")
	public List<Pedido> consultarPorNoEnviados();
}
