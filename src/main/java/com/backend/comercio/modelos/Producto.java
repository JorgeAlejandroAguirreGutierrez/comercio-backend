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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Timestamp;
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
    
    @NotNull
    @Column(name = "precio")
    private Double precio;
	
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
	
	@Column(name = "material")
    private String material;
    
    @Column(name = "marca")
    private String marca;
	
	@Column(name = "compra")
    private Double compra;
	
    @Column(name = "descuento")
    private Double descuento;
	
    @Column(name = "garantia")
    private String garantia;
    
    @Column(name = "tamano")
    private String tamano;
    
    @Column(name = "caracteristica")
    private String caracteristica;
    
    @Column(name = "talla")
    private String talla;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "memoria")
    private String memoria;
    
    @Column(name = "procesador")
    private String procesador;
    
    @Column(name = "camara")
    private String camara;

    @JsonManagedReference
    @OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "producto_id")
    private List<Detalle> detalles;
    
    @JsonManagedReference
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "producto_id")
    private List<Imagen> imagenes;
	
    @Column(name = "disponible")
    private boolean disponible;
    
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "fecha_creacion", nullable = true)
    private Timestamp fechaCreacion;
    
    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "fecha_actualizacion", nullable = true)
    private Timestamp fechaActualizacion;
    
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
    
    public String getTamano() {
		return tamano;
	}
    
    public String getCaracteristica() {
		return caracteristica;
	}
    
    public String getTalla() {
		return talla;
	}
    
    public String getColor() {
		return color;
	}
    
    public String getProcesador() {
		return procesador;
	}
    
    public String getMemoria() {
		return memoria;
	}
    public String getCamara() {
		return camara;
	}
    
    public List<Imagen> getImagenes() {
		return imagenes;
	}
    
    public boolean isDisponible() {
		return disponible;
	}
    
    public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
    
    public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
    
    public Timestamp getFechaActualizacion() {
		return fechaActualizacion;
	}
}
