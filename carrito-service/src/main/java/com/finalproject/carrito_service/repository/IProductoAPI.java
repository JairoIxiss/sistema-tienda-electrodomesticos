package com.finalproject.carrito_service.repository;

import com.finalproject.carrito_service.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "producto-service")
public interface IProductoAPI {

    @GetMapping("/productos/traer")
    public List<ProductoDTO> traerProductos();

}
