package com.escalab.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escalab.exception.ModeloNotFoundException;
import com.escalab.model.Producto;
import com.escalab.service.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	
	@Autowired
	private IProductoService service;
	
	public ResponseEntity<List<Producto>> listar(){
		List<Producto> lista= service.listar();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) {
		Producto cli = service.leerPorId(id);
		if (cli.getId_Producto() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
			
		}
		return new ResponseEntity<Producto>(cli, HttpStatus.OK);
		
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Producto>> listarPageable(Pageable pageable) {
		Page<Producto> productos = service.listarPageable(pageable);
		return new ResponseEntity<Page<Producto>>(productos, HttpStatus.OK);
	}
	
	 @PostMapping 
	 public ResponseEntity<Object> registrar(@Valid @RequestBody Producto productos){
		 Producto cli = service.registrar(productos);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productos.getId_Producto()).toUri();
		 return ResponseEntity.created(location).build();
	 }
	 
	 @PutMapping
		public ResponseEntity<Producto> modificar(@Valid @RequestBody Producto productos) {
		 Producto cli = service.modificar(productos);
			return new ResponseEntity<Producto>(cli, HttpStatus.OK);
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
			Producto cli = service.leerPorId(id);
			if (cli.getId_Producto() == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
			}
			service.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
}
