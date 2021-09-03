package com.backend.comercio.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "subsubcategoria")
public class Subsubcategoria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "descripcion", unique = true)
    private String descripcion;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "subcategoria_id")
    private Subcategoria subcategoria;
	
	public Subsubcategoria() {
		
	}
	
	public Subsubcategoria(long id) {
		this.id=id;
	}
	
	public Subsubcategoria(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public Subsubcategoria(long id, String descripcion) {
		this.id=id;
		this.descripcion=descripcion;
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
	
	public Subcategoria getSubcategoria() {
		return subcategoria;
	}
}
