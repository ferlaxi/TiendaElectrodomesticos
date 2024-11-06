package com.project.carts_service.repository;

import com.project.carts_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "products-service")
public interface ProductAPI {

    @GetMapping("products/get")
    public List<ProductDTO> getProducts();
}
