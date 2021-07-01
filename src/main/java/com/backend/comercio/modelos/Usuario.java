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

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
	
	@NotNull
    @NotEmpty
    @Column(name = "identificacion")
    private String identificacion;
	
	@NotNull
    @NotEmpty
    @Column(name = "contrasena")
    private String contrasena;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private List<Sesion> sesiones;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String identificacion, String contrasena, List<Sesion> sesiones) {
		this.nombre=nombre;
		this.identificacion=identificacion;
		this.contrasena=contrasena;
		this.sesiones=sesiones;
	}
	
    public long getId() {
		return id;
	}
	
    public String getNombre() {
		return nombre;
	}
    
    public String getIdentificacion() {
		return identificacion;
	}
    
    public String getContrasena() {
		return contrasena;
	}
}
