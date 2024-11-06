package com.project.carts_service.controller;

import com.project.carts_service.dto.CartDTO;
import com.project.carts_service.model.Cart;
import com.project.carts_service.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private ICartService cartServ;

    @PostMapping("/create")
    ResponseEntity<String> createCart (@RequestBody Cart cart) {
        cartServ.crateCart(cart);
        return new ResponseEntity<>("Cart Created", HttpStatus.CREATED);
    }

    @GetMapping("/get")
    ResponseEntity<List<CartDTO>> getCarts () {
        return new ResponseEntity<>(cartServ.getCarts(), HttpStatus.OK);
    }

    @PutMapping("/edit/{cartId}")
    ResponseEntity<String> editCart (@PathVariable Long cartId,
                                     @RequestBody Cart editedCart) {
        cartServ.editCart(cartId, editedCart);
        return new ResponseEntity<>("Cart Edited", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartId}")
    ResponseEntity<String> deleteCart (@PathVariable Long cartId) {
        cartServ.deleteCart(cartId);
        return new ResponseEntity<>("Cart Deleted", HttpStatus.OK);
    }

    @GetMapping("/get/{cartId}")
    ResponseEntity<CartDTO> getCart (@PathVariable Long cartId) {
        return new ResponseEntity<>(cartServ.getCart(cartId), HttpStatus.OK);
    }
}
