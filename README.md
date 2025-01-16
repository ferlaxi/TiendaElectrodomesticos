# Tienda Electrodomésticos API 

La API "Tienda Electrodomésticos" está desarrollada con Java utilizando Spring Boot y Spring Cloud, implementando una arquitectura de microservicios que ofrece una solución escalable y modular para gestionar productos, carritos de compra y ventas de una tienda en línea de electrodomésticos. 

## Arquitectura del proyecto 📚

- **products-service**: Gestiona el inventario de productos y sus detalles.

- **cart-service**: Maneja los carritos de compra de los usuarios, permitiendo agregar, eliminar y actualizar productos.

- **sales-service**: Procesa las ventas, gestionando la creación de pedidos y el seguimiento de transacciones.

- **api-gateway**: Actúa como un punto de entrada unificado para todos los microservicios, proporcionando una capa de abstracción para las peticiones y balanceo de carga.
- **eureka-server**: Implementa un servidor de descubrimiento de servicios, permitiendo que los microservicios se encuentren y comuniquen de manera dinámica.

Gracias a la utilización de Spring Cloud, esta arquitectura está diseñada para ser altamente escalable y resistente, optimizando el rendimiento y la capacidad de gestión a medida que la tienda crece.

## Patrones de diseño implementados 📑

La API "Tienda Electrodomésticos" utiliza los siguientes patrones de diseño para mejorar la escalabilidad y resiliencia:

- **Load Balancing de Spring Cloud Load Balancer**: Distribuye las solicitudes entre varias instancias de los microservicios para equilibrar la carga y mejorar el rendimiento.

- **API Gateway de Spring Cloud Gateway**: Centraliza el acceso a todos los microservicios a través de un único punto, gestionando el enrutamiento, la autenticación y la seguridad.

- **Config Server**: Centraliza y gestiona la configuración de todos los microservicios, permitiendo actualizaciones dinámicas sin necesidad de reiniciar los servicios.

- **Circuit Breaker de Resilience4J**: Protege los microservicios de fallos al detener el flujo de solicitudes hacia un servicio con problemas, evitando que los errores se propaguen.



## Endpoints de cada Microservicio

#### **Microservicio Productos**
```http
  "POST /products/create"
```

```http
  "GET /products/get"
```

```http
  "GET /products/get/{productId}"
```

```http
  "PUT /products/edit/{productId}"
```

```http
  "DELETE /products/delete/{productId}"
```

#### **Microservicio Carritos**

```http
  "POST /carts/create"
```

```http
  "GET /carts/get"
```

```http
  "GET /carts/get/{cartId}"
```

```http
  "PUT /carts/edit/{cartId}"
```

```http
  "DELETE /carts/delete/{cartId}"
```

#### **Microservicio Ventas**

```http
  "POST /sales/create"
```

```http
  "GET /sales/get"
```

```http
  "GET /sales/get/{saleId}"
```

```http
  "PUT /sales/edit/{saleId}"
```

```http
  "DELETE /sales/delete/{saleId}"
```
