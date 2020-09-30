package com.escalab.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "Producto")
public class Producto {

	@Id
	@Column(name = "id_Producto", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Producto;	

		
	@ManyToOne
	@JoinColumn(name = "id_Marca", nullable = false, foreignKey = @ForeignKey(name = "FK_producto_marca"))
	private Marca marca;
	
	
	@Column(name = "valor_Producto", nullable = false, length= 70)
	private Integer valor_Producto;

	@Size(min = 5, message = "Producto debe tener descripcion")
	@Column(name = "descripcion", nullable = false, length= 70)
	private String descripcion;
	
	@OneToMany(mappedBy = "producto", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<CompraProducto> compraProducto;

	public Integer getId_Producto() {
		return id_Producto;
	}

	public void setId_Producto(Integer id_Producto) {
		this.id_Producto = id_Producto;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Integer getValor_Producto() {
		return valor_Producto;
	}

	public void setValor_Producto(Integer valor_Producto) {
		this.valor_Producto = valor_Producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CompraProducto> getCompraProducto() {
		return compraProducto;
	}

	public void setCompraProducto(List<CompraProducto> compraProducto) {
		this.compraProducto = compraProducto;
	}

	
}
