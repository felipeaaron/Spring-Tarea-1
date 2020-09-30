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

@Entity
@Table(name = "Marca")
public class Marca {
	
	@Id
	@Column(name = "id_Marca", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Marca;
	
	@Column(name = "descripcion", nullable = false, length= 70)
	private String descripcion;
	
	@Column(name = "direccion", nullable = false, length= 70)
	private String direccion;

	@Column(name = "ciudad", nullable = false, length= 40)
	private String ciudad;
	
	@OneToMany(mappedBy = "marca", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Producto> producto;

	public Integer getId_Marca() {
		return id_Marca;
	}

	public void setId_Marca(Integer id_Marca) {
		this.id_Marca = id_Marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}


	
	

}
