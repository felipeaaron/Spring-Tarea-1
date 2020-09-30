package com.escalab.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Cliente;
	
	@Size(min = 3, message = "Nombre debe tener 3 caract minimo")
	@Column(name = "nombre_Cliente", nullable = false, length= 70)
	private String nombreCliente;
	
	
	@Column(name = "dircliente", nullable = false)
	private String dircliente;
	
	@Column(name = "telcliente", nullable = false)
	private String telcliente;

	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Venta> venta;

	public Integer getId_Cliente() {
		return id_Cliente;
	}

	public void setId_Cliente(Integer id_Cliente) {
		this.id_Cliente = id_Cliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDircliente() {
		return dircliente;
	}

	public void setDircliente(String dircliente) {
		this.dircliente = dircliente;
	}

	public String getTelcliente() {
		return telcliente;
	}

	public void setTelcliente(String telcliente) {
		this.telcliente = telcliente;
	}

	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}
	
	

	

	
}
