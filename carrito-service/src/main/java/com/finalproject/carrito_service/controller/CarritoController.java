package com.finalproject.carrito_service.controller;

import com.finalproject.carrito_service.dto.CarritoDTO;
import com.finalproject.carrito_service.dto.ProductoDTO;
import com.finalproject.carrito_service.model.Carrito;
import com.finalproject.carrito_service.service.ICarritoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private ICarritoService servCarrito;

    public String fallbackTraerProductos (Throwable throwable){
        return "Estamos experimentando problemas, intenta mas tarde";
    }

    @Value("${server.port}")
    private int serverPort;

    @PostMapping("/crear")
    @CircuitBreaker(name = "producto-service", fallbackMethod = "fallbackTraerProductos")
    @Retry(name = "producto-service")
    public String crearCarrito(@RequestBody CarritoDTO carrito){
        servCarrito.saveCarrito(carrito.getCodigos());
        return "El carrito ha sido creado con exito";
    }

    @GetMapping("/traer-todos")
    public List<Carrito> traerCarritos(){
        return servCarrito.getCarritos();
    }

    @GetMapping("/traer/{idCarrito}")
    public Carrito traerCarritos(@PathVariable Long idCarrito){
        System.out.println("Consumiendo del puerto: "+ serverPort);
        return servCarrito.findCarrito(idCarrito);
    }

    @DeleteMapping("/borrar/{idCarrito}")
    public String borrarCarrito(@PathVariable Long idCarrito){
        servCarrito.deleteCarrito(idCarrito);
        return "EL carrito se ha eliminado con exito";
    }

    @PutMapping("/editar/{idCarrito}")
    @CircuitBreaker(name = "producto-service", fallbackMethod = "fallbackTraerProductos")
    @Retry(name = "producto-service")
    public Carrito editarCarrito(@PathVariable Long idCarrito, @RequestBody CarritoDTO datosNuevos){
        return servCarrito.editCarrito(idCarrito,datosNuevos.getCodigos());
    }

}
