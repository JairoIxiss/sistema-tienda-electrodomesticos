package com.finalproject.carrito_service.service;

import com.finalproject.carrito_service.dto.CarritoDTO;
import com.finalproject.carrito_service.dto.ProductoDTO;
import com.finalproject.carrito_service.model.Carrito;
import com.finalproject.carrito_service.repository.ICarritoRepository;
import com.finalproject.carrito_service.repository.IProductoAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService implements ICarritoService {
    @Override
    public List<ProductoDTO> getProductos() {
        return productoAPI.traerProductos();
    }

    @Autowired
    private ICarritoRepository repoCarrito;

    @Autowired
    private IProductoAPI productoAPI;

    @Override
    public Carrito saveCarrito(List<Long> codigosProductos) {

        Carrito carrito = new Carrito();
        List<ProductoDTO> listaProductos = productoAPI.traerProductos();
        List<ProductoDTO> productosCarrito = new ArrayList<>();
        Double total = 0.0;

        //For para filtrar los productos que contiene el carrito y calcular el total.
        for(ProductoDTO producto: listaProductos){
            if(codigosProductos.contains(producto.getCodigo())){
                productosCarrito.add(producto);
                total += producto.getPrecio();
            }
        }

        carrito.setTotal(total);
        carrito.setCodigosProductos(codigosProductos);
        //createException();
        repoCarrito.save(carrito);

        return carrito;
    }

    @Override
    public List<Carrito> getCarritos() {
        return repoCarrito.findAll();
    }

    @Override
    public void deleteCarrito(Long idCarrito) {
        repoCarrito.deleteById(idCarrito);
    }

    @Override
    public Carrito findCarrito(Long idCarrito) {
        return repoCarrito.findCarritoByIdCarrito(idCarrito);
    }

    @Override
    public Carrito editCarrito(Long idCarrito, List<Long> codigosProductos) {

        Carrito carrito = this.findCarrito(idCarrito);

        List<ProductoDTO> listaProductos = productoAPI.traerProductos();
        List<ProductoDTO> productosCarrito = new ArrayList<>();
        Double total = 0.0;

        //For para filtrar los productos que contiene el carrito.
        for(ProductoDTO producto: listaProductos){
            if(codigosProductos.contains(producto.getCodigo())){
                productosCarrito.add(producto);
                total += producto.getPrecio();
            }
        }

        carrito.setTotal(total);
        carrito.setCodigosProductos(codigosProductos);

        return repoCarrito.save(carrito);
    }

    public void createException(){
        throw  new RuntimeException("Prueba para circuit breaker");
    }

}
