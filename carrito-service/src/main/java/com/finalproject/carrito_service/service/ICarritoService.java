package com.finalproject.carrito_service.service;

import com.finalproject.carrito_service.dto.ProductoDTO;
import com.finalproject.carrito_service.model.Carrito;

import java.util.List;

public interface ICarritoService {

    public Carrito saveCarrito(List<Long> codigosProductos);
    public List<Carrito> getCarritos();
    public void deleteCarrito(Long idCarrito);
    public Carrito findCarrito(Long idCarrito);
    public Carrito editCarrito(Long idCarrito, List<Long> codigosProductos);

    public List<ProductoDTO> getProductos();

}
