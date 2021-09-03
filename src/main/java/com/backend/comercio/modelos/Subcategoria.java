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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "subcategoria")
public class Subcategoria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "descripcion", unique = true)
    private String descripcion;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "subcategoria_id")
	private List<Subsubcategoria> subsubcategorias;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
	
	public Subcategoria() {
		
	}
	
	public Subcategoria(long id) {
		this.id=id;
	}
	
	public Subcategoria(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public Subcategoria(long id, String descripcion) {
		this.id=id;
		this.descripcion=descripcion;
	}
	
	public Subcategoria(String descripcion, List<Subsubcategoria> subsubcategorias) {
		this.descripcion=descripcion;
		this.subsubcategorias=subsubcategorias;
	}
	
	public long getId() {
		return id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Subsubcategoria> getSubsubcategorias() {
		return subsubcategorias;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
}
