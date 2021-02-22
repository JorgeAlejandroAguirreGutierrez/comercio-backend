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
    @JoinColumn(name = "talla_id", nullable = true)
    private Talla talla;
    
    @ManyToOne
    @JoinColumn(name = "color_id", nullable = true)
    private Color color;
    
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = true)
    private Producto producto;
	
    public double getTotal() {
		return total;
	}
	
	public Talla getTalla() {
		return talla;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Producto getProducto() {
		return producto;
	}
}
