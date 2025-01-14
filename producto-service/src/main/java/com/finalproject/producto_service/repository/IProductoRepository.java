package com.finalproject.producto_service.repository;

import com.finalproject.producto_service.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    Producto findProductoByCodigo(Long codigo);

}
