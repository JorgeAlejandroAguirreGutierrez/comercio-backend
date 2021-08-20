package com.backend.comercio.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
	@ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
	@NotNull
	@ManyToOne
    @JoinColumn(name = "subcategoria_id")
    private Subcategoria subcategoria;
	
	@NotNull
	@ManyToOne
    @JoinColumn(name = "subsubcategoria_id")
    private Subsubcategoria subsubcategoria;
	
	@Column(name = "compra")
    private Double compra;
	
	@NotNull
    @Column(name = "precio")
    private Double precio;
	
    @Column(name = "descuento")
    private Double descuento;
	
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
    
    public String getTitulo() {
		return titulo;
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
    
    public Categoria getCategoria() {
		return categoria;
	}
    
    public Subcategoria getSubcategoria() {
		return subcategoria;
	}
    
    public Subsubcategoria getSubsubcategoria() {
		return subsubcategoria;
	}
     
    public Double getPrecio() {
		return precio;
	}
    
    public Double getDescuento() {
		return descuento;
	}
    
    public Double getCompra() {
		return compra;
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
    
    public boolean isDisponible() {
		return disponible;
	}
    
    public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
