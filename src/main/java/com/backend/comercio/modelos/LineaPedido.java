package com.backend.comercio.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "linea_pedido")
public class LineaPedido {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "total")
    private double total;
    
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = true)
    private Producto producto;
	
    public double getTotal() {
		return total;
	}
    
    public void setTotal(double total) {
		this.total = total;
	}
	
	public Producto getProducto() {
		return producto;
	}
}
