package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.CompraProducto;

public interface ICompraProductoRepo extends JpaRepository<CompraProducto, Integer> {

}
