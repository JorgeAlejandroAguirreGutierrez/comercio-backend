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
@Table(name = "cliente")
public class Cliente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
	
	@NotNull
    @NotEmpty
    @Column(name = "celular")
    private String celular;
	
	@NotNull
    @NotEmpty
    @Column(name = "direccion")
    private String direccion;
	
	public Cliente() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Cliente(String celular) {
		this.celular=celular;
	}
	
    public long getId() {
		return id;
	}
	
    public String getCelular() {
		return celular;
	}
    
    public String getDireccion() {
		return direccion;
	}
}
