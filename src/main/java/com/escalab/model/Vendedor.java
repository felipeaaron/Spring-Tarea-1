package com.escalab.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Vendedor")
public class Vendedor {

	@Id
	@Column(name = "id_Vendedor", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Vendedor;
	
	
	@ManyToOne
	@JoinColumn(name = "id_Supervisor", nullable = false, foreignKey = @ForeignKey(name = "FK_vendedor_supervisor"))
	private Supervisor supervisor;
	

	@Size(min = 3, message = "Vendedor debe tener un nombre")
	@Column(name = "nombre_Vendedor", nullable = false)
	private String nombre_Vendedor;
	
	@Size(min = 3, message = "Vendedor debe tener una direccion")
	@Column(name = "DirVendedor", nullable = false, length= 70)
	private String DirVendedor;
	

	@OneToMany(mappedBy = "vendedor", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Venta> venta;


	public Integer getId_Vendedor() {
		return id_Vendedor;
	}


	public void setId_Vendedor(Integer id_Vendedor) {
		this.id_Vendedor = id_Vendedor;
	}


	public Supervisor getSupervisor() {
		return supervisor;
	}


	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}


	public String getNombre_Vendedor() {
		return nombre_Vendedor;
	}


	public void setNombre_Vendedor(String nombre_Vendedor) {
		this.nombre_Vendedor = nombre_Vendedor;
	}


	public String getDirVendedor() {
		return DirVendedor;
	}


	public void setDirVendedor(String dirVendedor) {
		DirVendedor = dirVendedor;
	}


	public List<Venta> getVenta() {
		return venta;
	}


	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	
	
}
