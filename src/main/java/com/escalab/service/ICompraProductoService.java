package com.escalab.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.CompraProducto;

public interface ICompraProductoService extends JpaRepository<CompraProducto, Integer> {

}
