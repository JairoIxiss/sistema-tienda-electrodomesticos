package com.finalproject.producto_service.service;

import com.finalproject.producto_service.model.Producto;

import java.util.List;

public interface IProductoService {

    public Producto saveProducto(Producto producto);
    public List<Producto> getProductos();
    public Producto findProducto(Long codigo);
    public void deleteProducto(Long codigo);
    public Producto editProducto(Long codigo, Producto datosNuevos);

}
