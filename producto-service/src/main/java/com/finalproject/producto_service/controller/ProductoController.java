package com.finalproject.producto_service.controller;

import com.finalproject.producto_service.model.Producto;
import com.finalproject.producto_service.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService servProducto;

    @Value("${server.port}")
    private int serverPort;

    @PostMapping("/crear")
    public String crearProducto(@RequestBody Producto producto){
        servProducto.saveProducto(producto);
        return "El producto se ha creado correctamente";
    }

    @GetMapping("/traer")
    public List<Producto> traerProductos(){
        System.out.println("Consumiendo del puerto: " + serverPort);
        return servProducto.getProductos();
    }

    @GetMapping("/traer/{codigo}")
    public Producto traerProducto(@PathVariable Long codigo){
        return servProducto.findProducto(codigo);
    }

    @DeleteMapping("/borrar/{codigo}")
    public String borrarProducto(@PathVariable Long codigo){
        servProducto.deleteProducto(codigo);
        return "EL producto se ha eliminado con exito";
    }

    @PutMapping("/editar/{codigo}")
    public Producto editarProducto(@PathVariable Long codigo, @RequestBody Producto nuevosDatos){
        return servProducto.editProducto(codigo,nuevosDatos);
    }

}
