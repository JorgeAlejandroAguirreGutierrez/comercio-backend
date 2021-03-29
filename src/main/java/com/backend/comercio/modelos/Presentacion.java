package com.backend.comercio.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "presentacion")
public class Presentacion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "talla_id", nullable = true)
    private Talla talla;
	
	@ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "color_id", nullable = true)
    private Color color;
	
	@ManyToOne
    @JoinColumn(name = "producto_id", nullable = true)
    private Producto producto;
	
	public long getId() {
		return id;
	}
	
	public Talla getTalla() {
		return talla;
	}
	
	public Color getColor() {
		return color;
	}
	
	@JsonBackReference
	public Producto getProducto() {
		return producto;
	}
}
