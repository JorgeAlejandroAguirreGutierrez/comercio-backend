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
			+" WHERE p.confirmar=false AND p.pagado=false AND p.enviado=false")
	public List<Pedido> consultarAbiertos();
	
	@Query(value="select p from Pedido p"  
			+" WHERE p.confirmar=true AND p.pagado=false AND p.enviado=false")
	public List<Pedido> consultarConfirmados();
	
	@Query(value="select p from Pedido p"  
			+" WHERE p.confirmar=true AND p.pagado=true AND p.enviado=false")
	public List<Pedido> consultarPagados();
	
	@Query(value="select p from Pedido p"  
			+" WHERE p.confirmar=true AND p.pagado=true AND p.enviado=true")
	public List<Pedido> consultarEnviados();
	
	@Query(value="select p from Pedido p JOIN p.cliente c"  
			+" WHERE p.confirmar=false AND p.pagado=false AND p.enviado=false AND c.celular=:celular")
	public List<Pedido> consultarCelularYAbiertos(String celular);
	
	@Query(value="select p from Pedido p JOIN p.cliente c"  
			+" WHERE p.confirmar=true AND p.pagado=false AND p.enviado=false AND c.celular=:celular")
	public List<Pedido> consultarCelularYConfirmados(String celular);
	
	@Query(value="select p from Pedido p JOIN p.cliente c"  
			+" WHERE p.confirmar=true AND p.pagado=true AND p.enviado=false AND c.celular=:celular")
	public List<Pedido> consultarCelularYPagados(String celular);
	
	@Query(value="select p from Pedido p JOIN p.cliente c"  
			+" WHERE p.confirmar=true AND p.pagado=true AND p.enviado=true AND c.celular=:celular")
	public List<Pedido> consultarCelularYEnviados(String celular);
}
