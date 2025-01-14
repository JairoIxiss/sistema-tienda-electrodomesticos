package com.finalproject.producto_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Producto {

    @Id
    private Long codigo;
    private String nombre;
    private String marca;
    private Double precio;

}
