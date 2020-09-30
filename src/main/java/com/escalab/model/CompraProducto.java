package com.escalab.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CompraProducto")
public class CompraProducto {
	
	@Id
	@JoinColumn(name = "id_CompraProducto", nullable = false)
	private Integer id_CompraProducto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_compraproducto_producto"))
	private Producto producto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false, foreignKey = @ForeignKey(name = "FK_compraproducto_venta"))
	private Venta venta;
	
	


	public Integer getId_CompraProducto() {
		return id_CompraProducto;
	}


	public void setId_CompraProducto(Integer id_CompraProducto) {
		this.id_CompraProducto = id_CompraProducto;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Venta getVenta() {
		return venta;
	}


	public void setVenta(Venta venta) {
		this.venta = venta;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_CompraProducto == null) ? 0 : id_CompraProducto.hashCode());
		return result;
	}



}
