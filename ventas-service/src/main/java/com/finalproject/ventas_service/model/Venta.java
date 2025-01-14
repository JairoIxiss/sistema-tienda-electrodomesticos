package com.finalproject.ventas_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    private LocalDate fechaVenta;
    private Double montoTotal;
    private Long idCarrito;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> idProductos;

}
