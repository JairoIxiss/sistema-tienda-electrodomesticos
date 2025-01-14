package com.finalproject.ventas_service.service;

import com.finalproject.ventas_service.dto.CarritoDTO;
import com.finalproject.ventas_service.dto.VentaDTO;
import com.finalproject.ventas_service.model.Venta;
import com.finalproject.ventas_service.repository.ICarritoAPI;
import com.finalproject.ventas_service.repository.IVentaRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository repoVenta;

    @Autowired
    private ICarritoAPI apiCarrito;

    @Override
    public Venta saveVenta(LocalDate fechaVenta, Long idCarrito) {
        Venta venta = new Venta();
        CarritoDTO carrito = apiCarrito.traerCarritos(idCarrito);

        venta.setFechaVenta(fechaVenta);
        venta.setIdCarrito(idCarrito);
        venta.setMontoTotal(carrito.getTotal());
        venta.setIdProductos(carrito.getCodigosProductos());
        //createException();
        repoVenta.save(venta);

        return venta;
    }

    @Override
    public List<Venta> getVentas() {
        return repoVenta.findAll();
    }

    @Override
    public Venta getVenta(Long idVenta) {
        return repoVenta.findById(idVenta).orElse(null);
    }

    @Override
    public void deleteVenta(Long idVenta) {
        repoVenta.deleteById(idVenta);
    }

    @Override
    public Venta editVenta(Long idVenta, VentaDTO nuevosDatos) {

        Venta ventaEditar= this.getVenta(idVenta);
        CarritoDTO carrito = apiCarrito.traerCarritos(nuevosDatos.getIdCarrito());

        ventaEditar.setFechaVenta(nuevosDatos.getFechaVenta());
        ventaEditar.setIdCarrito(nuevosDatos.getIdCarrito());
        ventaEditar.setMontoTotal(carrito.getTotal());
        ventaEditar.setIdProductos(carrito.getCodigosProductos());

        repoVenta.save(ventaEditar);

        return ventaEditar;
    }

    public void createException(){
        throw  new RuntimeException("Prueba para circuit breaker");
    }

}
