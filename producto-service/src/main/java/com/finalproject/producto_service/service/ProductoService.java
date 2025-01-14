package com.finalproject.producto_service.service;

import com.finalproject.producto_service.model.Producto;
import com.finalproject.producto_service.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository repoProduct;

    @Override
    public Producto saveProducto(Producto producto) {
        return repoProduct.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return repoProduct.findAll();
    }

    @Override
    public Producto findProducto(Long codigo) {
        return repoProduct.findProductoByCodigo(codigo);
    }

    @Override
    public void deleteProducto(Long codigo) {
    repoProduct.deleteById(codigo);
    }

    @Override
    public Producto editProducto(Long codigo,Producto datosNuevos) {

        Producto productoEditar = this.findProducto(codigo);

        productoEditar.setCodigo(datosNuevos.getCodigo());
        productoEditar.setNombre(datosNuevos.getNombre());
        productoEditar.setMarca(datosNuevos.getMarca());
        productoEditar.setPrecio(datosNuevos.getPrecio());

        return this.saveProducto(productoEditar);
    }
}
