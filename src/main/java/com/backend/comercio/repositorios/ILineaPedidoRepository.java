package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.LineaPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ILineaPedidoRepository extends JpaRepository<LineaPedido, Long>, JpaSpecificationExecutor<LineaPedido> {
}
