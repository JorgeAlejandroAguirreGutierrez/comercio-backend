package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.Categoria;
import com.backend.comercio.modelos.Detalle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IDetalleRepository extends JpaRepository<Detalle, Long>, JpaSpecificationExecutor<Detalle> {
}
