package com.project.sales_service.repository;

import com.project.sales_service.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "carts-service")
public interface CartAPI {

    @GetMapping("carts/get")
    public List<CartDTO> getCarts ();

    @GetMapping("carts/get/{cartId}")
    public CartDTO getCartById(@PathVariable("cartId") Long cartId);
}
