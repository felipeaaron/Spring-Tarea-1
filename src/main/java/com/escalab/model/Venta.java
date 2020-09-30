package com.escalab.model;

import java.time.LocalDateTime;
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
@Table(name = "Venta")
public class Venta {
	
	
	@Id
	@Column(name = "id_Venta", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Venta;
	
	@ManyToOne
	@JoinColumn(name = "id_Vendedor", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_vendedor"))
	private Vendedor vendedor;
	
	@ManyToOne
	@JoinColumn(name = "id_Cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_cliente"))
	private Cliente cliente;
	
		
	@Size(min = 3, message = "Costo debe ser superior a 0")
	@Column(name = "Costo", nullable = false, length= 70)
	private Integer costo;
	
	@Column(name = "fecha_Venta", nullable = false)
	private LocalDateTime fecha_Venta;

	@OneToMany(mappedBy = "venta", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<CompraProducto> compraProducto;

	public Integer getId_Venta() {
		return id_Venta;
	}

	public void setId_Venta(Integer id_Venta) {
		this.id_Venta = id_Venta;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public LocalDateTime getFecha_Venta() {
		return fecha_Venta;
	}

	public void setFecha_Venta(LocalDateTime fecha_Venta) {
		this.fecha_Venta = fecha_Venta;
	}

	public List<CompraProducto> getCompraProducto() {
		return compraProducto;
	}

	public void setCompraProducto(List<CompraProducto> compraProducto) {
		this.compraProducto = compraProducto;
	}

}
