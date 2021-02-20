package com.backend.comercio.modelos;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "fecha")
    private Date fecha;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "fecha_entrega")
    private Date fechaEntrega;
	
    @Column(name = "qr")
    private String qr;
    
    @Column(name = "cantidad_qr")
    private String cantidadQr;
    
    @Column(name = "total")
    private double total;
    
    @Column(name = "generar")
    private boolean generar;
    
    @Column(name = "confirmar")
    private boolean confirmar; 
    
    @Column(name = "enviado")
    private boolean enviado;
	
	@Column(name = "pagado")
    private boolean pagado;
	
	@ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private List<LineaPedido> lineasPedido;
	
	
	public long getId() {
		return id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getQr() {
		return qr;
	}
	
	public String getCantidadQr() {
		return cantidadQr;
	}
	
	public double getTotal() {
		return total;
	}
	
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	
	public boolean isGenerar() {
		return generar;
	}
	
	public boolean isConfirmar() {
		return confirmar;
	}
	
	public boolean isPagado() {
		return pagado;
	}
	
	public boolean isEnviado() {
		return enviado;
	}
	
	public void setQr(String qr) {
		this.qr = qr;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void setGenerar(boolean generar) {
		this.generar = generar;
	}
	
	public void setConfirmar(boolean confirmar) {
		this.confirmar = confirmar;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
