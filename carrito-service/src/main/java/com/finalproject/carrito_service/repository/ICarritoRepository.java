package com.finalproject.carrito_service.repository;

import com.finalproject.carrito_service.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoRepository extends JpaRepository<Carrito, Long> {

    Carrito findCarritoByIdCarrito(Long idCarrito);

}
