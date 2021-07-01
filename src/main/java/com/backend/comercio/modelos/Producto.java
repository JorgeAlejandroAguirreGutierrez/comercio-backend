package com.backend.comercio.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    @Column(name = "titulo")
    private String titulo;
	
    @Column(name = "descripcion")
    private String descripcion;
	
    @Column(name = "material")
    private String material;
    
    @Column(name = "marca")
    private String marca;
	
	@NotNull
    @NotEmpty
    @Column(name = "categoria")
    private String categoria;
	
	@NotNull
    @NotEmpty
    @Column(name = "subcategoria")
    private String subcategoria;
	
	@NotNull
    @Column(name = "compra")
    private double compra;
	
	@NotNull
    @Column(name = "precio")
    private double precio;
	
    @Column(name = "descuento")
    private double descuento;
	
    @Column(name = "garantia")
    private String garantia;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private List<Presentacion> presentaciones;

	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private List<Imagen> imagenes;
	
    @Column(name = "disponible")
    private boolean disponible;
    
    public long getId() {
		return id;
	}
    
    public String getDescripcion() {
		return descripcion;
	}
    public String getMaterial() {
		return material;
	}
    public String getMarca() {
		return marca;
	}
    
    public String getCategoria() {
		return categoria;
	}
    
    public String getSubcategoria() {
		return subcategoria;
	}
     
    public double getPrecio() {
		return precio;
	}
    
    public double getDescuento() {
		return descuento;
	}
    
    public String getGarantia() {
		return garantia;
	}
    
    public List<Imagen> getImagenes() {
		return imagenes;
	}
    
    @JsonManagedReference
    public List<Presentacion> getPresentaciones() {
		return presentaciones;
	}
    
    public double getCompra() {
		return compra;
	}
    
    public boolean isDisponible() {
		return disponible;
	}
    
    public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
