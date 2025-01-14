package com.finalproject.carrito_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ProductoDTO {

    private Long codigo;
    private String nombre;
    private String marca;
    private Double precio;

}
