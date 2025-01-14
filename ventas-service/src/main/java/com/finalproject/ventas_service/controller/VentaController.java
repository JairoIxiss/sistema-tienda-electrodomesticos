package com.finalproject.ventas_service.controller;

import com.finalproject.ventas_service.dto.VentaDTO;
import com.finalproject.ventas_service.model.Venta;
import com.finalproject.ventas_service.service.IVentaService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService servVenta;

    public String fallbackTraerCarrito(Throwable throwable){
        return "Estamos experimentado problemas, por favor, espere";
    }

    @PostMapping("/crear")
    @CircuitBreaker(name = "carrito-service", fallbackMethod = "fallbackTraerCarrito")
    @Retry(name = "carrito-service")
    public String crearVenta(@RequestBody VentaDTO venta){
        servVenta.saveVenta(venta.getFechaVenta(), venta.getIdCarrito());
        return "La venta se ha creado con exito";
    }

    @GetMapping("/traer")
    public List<Venta> traerVentas(){
        return servVenta.getVentas();
    }

    @GetMapping("/traer/{idVenta}")
    public Venta traerVenta(@PathVariable Long idVenta){
        return servVenta.getVenta(idVenta);
    }

    @PutMapping("/editar/{idVenta}")
    @CircuitBreaker(name = "carrito-service", fallbackMethod = "fallbackTraerCarrito")
    @Retry(name = "carrito-service")
    public Venta editarVenta (@PathVariable Long idVenta, @RequestBody VentaDTO datosNuevos){
        return servVenta.editVenta(idVenta, datosNuevos);
    }

    @DeleteMapping("/borrar/{idVenta}")
    public String borrarVenta(@PathVariable Long idVenta){
        servVenta.deleteVenta(idVenta);
        return "La venta se ha elimando correctamenta";
    }

}
