package com.backend.comercio.repositorios;

import com.backend.comercio.modelos.Producto;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {
	@Query(value = "select count(*) FROM Producto")
    long consecutivo();
	
	@Query(value = "select p from Producto p WHERE date(p.fechaCreacion)<=:actually AND date(p.fechaCreacion)>=:before")
    public List<Producto> consultarPorUltimaFecha(Date actually, Date before);
}
