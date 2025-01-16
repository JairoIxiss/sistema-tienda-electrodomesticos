<h1 align="center"> Proyecto Tienda de Electrodomésticos con Microservicos </h1>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

## Descripción del Proyecto:
<div align="justify">
Este es un proyecto basado en microservicios, desarrollado en Java, que simula una tienda de electrodomésticos en línea. La arquitectura se compone de tres microservicios principales: Producto, Carrito de Compras, y Ventas. Utiliza Spring Boot para la creación de microservicios, con funcionalidades como descubrimiento de servicios, enrutamiento, balanceo de carga, tolerancia a fallos y centralización de configuraciones.
</div>

## Funcionalidades Principales:

### Microservicio de Productos

 - Gestiona la información de los electrodomésticos disponibles.
 - Permite listar los productos con detalles como: código, nombre, marca y precio.

### Microservicio de Carrito de Compras

- Permite crear y gestionar carritos de compras.
- Los usuarios pueden agregar y quitar productos del carrito.
- Calcula automáticamente el precio total del carrito, gracias a la consulta del microservicio Productos.

### Microservicio de Ventas

- Registra las ventas realizadas, asociándolas con carritos de compras.
- Cada venta tiene un identificador único y una fecha.
- La venta consulta el carrito para obtener el monto total y los productos incluidos.

## Arquitectura del proyecto:

- **Java y Spring Boot:** Plataforma para desarrollar los microservicios.
- **Eureka Server y API Gateway:** Para descubrimiento de servicios y gestión de enrutamiento.
- **Feign Client:** Para la comunicación entre microservicios.
- **Resilience4j (circuit breaker y retry):** Estrategias de tolerancia a fallos.
- **Load Balancer:** Para distribuir la carga entre los microservicios.
- **Config Server:** Para centralizar la gestión de configuraciones.

## Dependencias Clave:

- _**Maven:**_ Gestión de dependencias y construcción del proyecto.
- _**Lombok:**_ Para reducir el boilerplate code en entidades y DTOs.
- _**JPA + Hibernate:**_ Para la persistencia de datos en MySQL.
- _**Spring Web:**_ Para la creación de APIs RESTful.
- _**Base de Datos:**_ MySQL, ejecutado mediante **XAMPP** para la gestión y almacenamiento de datos.
- _**Postman:**_ Para pruebas de los endpoints.
- _**Docker:**_ Para la simulación de despliegue y contenedores.

## Endpoints del Proyecto:

#### Nota:
<div align="justify">
Todos los servicios están gestionados a través de un <strong>API Gateway</strong> que se ejecuta en <code>localhost:444</code>. Las URLs para interactuar con los microservicios siguen la siguiente estructura:
</div>

`System.out.println("Hola Mundo!");`


<p style="color: blue; background-color: white;">Este es un párrafo con fondo negro y texto blanco.</p>






