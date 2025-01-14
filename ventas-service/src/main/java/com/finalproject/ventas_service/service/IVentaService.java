package com.finalproject.ventas_service.service;

import com.finalproject.ventas_service.dto.VentaDTO;
import com.finalproject.ventas_service.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public Venta saveVenta(LocalDate fechaVenta, Long idCarrito);
    public List<Venta> getVentas();
    public Venta getVenta(Long idVenta);
    public void deleteVenta(Long idVenta);
    public Venta editVenta(Long idVenta, VentaDTO nuevosDatos);

}
