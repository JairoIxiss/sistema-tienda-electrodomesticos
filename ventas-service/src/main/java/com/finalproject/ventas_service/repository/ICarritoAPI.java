package com.finalproject.ventas_service.repository;

import com.finalproject.ventas_service.dto.CarritoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "carrito-service")
public interface ICarritoAPI {

    @GetMapping("/carrito/traer/{idCarrito}")
    public CarritoDTO traerCarritos(@PathVariable Long idCarrito);

}
