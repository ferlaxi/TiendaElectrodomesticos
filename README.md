# Tienda Electrodomésticos API 

La API "Tienda Electrodomésticos" está desarrollada con Java utilizando Spring Boot y Spring Cloud, implementando una arquitectura de microservicios que ofrece una solución escalable y modular para gestionar productos, carritos de compra y ventas de una tienda en línea de electrodomésticos. 

## Características Principales
- Arquitectura de microservicios con Spring Cloud para escalabilidad, resiliencia y gestión centralizada.
- Gestión eficiente de productos, carrito de compras y ventas integradas mediante microservicios independientes.
- Implementación de patrones de diseños para una arquitectura modular y eficiente.

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

### Requisitos del Sistema

- Java 17
- MySQL
- Maven

### Instrucciones de Implementación

1.  Clona el repositorio desde Github.

2.  Configura el archivo application.properties con los datos de tu base de datos MySQL local:
    (El archivo se encuentra en la ruta `src/main/resources/application.properties`)

   ```properties
        spring.jpa.hibernate.ddl-auto=update
        spring.datasource.url=${DB_URL}
        spring.datasource.username=${DB_USERNAME}
        spring.datasource.password=${DB_PASSWORD}
        spring.hibernate.database-platform=${DB_DIALECT}
   ```

4.  Ejecuta la aplicación.



## API REST

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
