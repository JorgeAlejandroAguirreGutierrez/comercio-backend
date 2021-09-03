package com.backend.comercio.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "detalle")
public class Detalle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "filtro")
    private String filtro;
	
	@Column(name = "valor")
    private String valor;
	
	@Column(name = "pvp")
    private double pvp;
	
	@Column(name = "stock")
    private long stock;
	
	@Column(name = "unidad")
    private String unidad;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "producto_id", nullable = true)
    private Producto producto;
	
	public long getId() {
		return id;
	}
	
	public String getFiltro() {
		return filtro;
	}
	
	public String getValor() {
		return valor;
	}
	
	public double getPvp() {
		return pvp;
	}
	
	public long getStock() {
		return stock;
	}
	
	public String getUnidad() {
		return unidad;
	}
}
