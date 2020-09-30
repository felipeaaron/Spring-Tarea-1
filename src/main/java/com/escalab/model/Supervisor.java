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
@Table(name = "Supervisor")
public class Supervisor {

	@Id
	@Column(name = "id_Supervisor", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Supervisor;
	
	@Size(min = 3, message = "Supervisor debe tener nombre")
	@Column(name = "nombre_Supervisor", nullable = false, length= 70)
	private String nombre_Supervisor;
	
	@Size(min = 3, message = "Supervisor debe tener una direccion")
	@Column(name = "dir_Supervisor", nullable = false, length= 70)
	private String dir_Supervisor;

	@Size(min = 8, message = "Supervisor debe tener un telefono")
	@Column(name = "tel_Supervisor", nullable = false, length= 12)
	private Integer tel_Supervisor;
	

	@OneToMany(mappedBy = "supervisor", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Vendedor> vendedor;


	public Integer getId_Supervisor() {
		return id_Supervisor;
	}


	public void setId_Supervisor(Integer id_Supervisor) {
		this.id_Supervisor = id_Supervisor;
	}


	public String getNombre_Supervisor() {
		return nombre_Supervisor;
	}


	public void setNombre_Supervisor(String nombre_Supervisor) {
		this.nombre_Supervisor = nombre_Supervisor;
	}


	public String getDir_Supervisor() {
		return dir_Supervisor;
	}


	public void setDir_Supervisor(String dir_Supervisor) {
		this.dir_Supervisor = dir_Supervisor;
	}


	public Integer getTel_Supervisor() {
		return tel_Supervisor;
	}


	public void setTel_Supervisor(Integer tel_Supervisor) {
		this.tel_Supervisor = tel_Supervisor;
	}


	public List<Vendedor> getVendedor() {
		return vendedor;
	}


	public void setVendedor(List<Vendedor> vendedor) {
		this.vendedor = vendedor;
	}

	
}
