package com.backend.comercio.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "subcategoria")
public class Subcategoria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "descripcion")
    private String descripcion;
	
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
}
