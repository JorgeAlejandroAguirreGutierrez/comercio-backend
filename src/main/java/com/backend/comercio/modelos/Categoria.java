package com.backend.comercio.modelos;

import java.util.List;

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


@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "descripcion", unique = true)
    private String descripcion;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private List<Subcategoria> subcategorias;
	
	public Categoria() {
		
	}
		
	public Categoria(long id) {
		this.id=id;
	}
	
	public Categoria(long id, String descripcion, List<Subcategoria> subcategorias) {
		this.id=id;
		this.descripcion=descripcion;
		this.subcategorias=subcategorias;
	}
	
	public Categoria(String descripcion, List<Subcategoria> subcategorias) {
		this.descripcion=descripcion;
		this.subcategorias=subcategorias;
	}
	
	public long getId() {
		return id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	
	public List<Subcategoria> getSubcategorias() {
		return subcategorias;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setSubcategorias(List<Subcategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}
}
