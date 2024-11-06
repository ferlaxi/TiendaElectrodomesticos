package com.project.carts_service.service;

import com.project.carts_service.dto.CartDTO;
import com.project.carts_service.model.Cart;

import java.util.List;

public interface ICartService {
    public void crateCart(Cart cart);
    public List<CartDTO> getCarts();
    public void editCart(Long cartId, Cart editedCart);
    public void deleteCart(Long cartId);
    public CartDTO getCart(Long cartId);
}
