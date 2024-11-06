package com.project.carts_service.service;

import com.project.carts_service.dto.CartDTO;
import com.project.carts_service.dto.ProductDTO;
import com.project.carts_service.model.Cart;
import com.project.carts_service.repository.ICartRepository;
import com.project.carts_service.repository.ProductAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService{

    @Autowired
    private ICartRepository cartRepo;

    @Autowired
    private ProductAPI productAPI;

    @Override
    public void crateCart(Cart cart) {
        cartRepo.save(cart);
    }

    @Override
    @CircuitBreaker(name = "products-service", fallbackMethod = "fallbackGetCarts")
    @Retry(name = "products-service")
    public List<CartDTO> getCarts() {

        List<CartDTO> listCarts = new ArrayList<CartDTO>();

        List<Cart> cartsList = cartRepo.findAll();
        List<ProductDTO> listProducts = productAPI.getProducts();

        for (Cart cart : cartsList) {

            CartDTO cartDTO = new CartDTO();
            cartDTO.setCartId(cart.getCartId());
            cartDTO.setTotal(cart.getTotal());
            List<ProductDTO> listProductCart = new ArrayList<ProductDTO>();

            for (Long productId : cart.getProductsId()) {
                for (ProductDTO product : listProducts) {
                    if (productId.equals(product.getProductId())) {
                        listProductCart.add(product);
                    }
                }
            }

            cartDTO.setProductsList(listProductCart);
            listCarts.add(cartDTO);
        }
        return listCarts;
    }

    public List<CartDTO> fallbackGetCarts (Throwable throwable) {
        return null;
    }

    @Override
    public void editCart(Long cartId, Cart editedCart) {
        Cart cart = cartRepo.findById(cartId).orElse(null);

        cart.setTotal(editedCart.getTotal());
        cart.setProductsId(editedCart.getProductsId());

        cartRepo.save(cart);
    }

    @Override
    public void deleteCart(Long cartId) {
        cartRepo.deleteById(cartId);
    }

    @Override
    @CircuitBreaker(name = "products-service", fallbackMethod = "fallbackGetCart")
    @Retry(name = "products-service")
    public CartDTO getCart(Long cartId) {
        Cart cart = cartRepo.findById(cartId).orElse(null);
        List<ProductDTO> productsList = productAPI.getProducts();

        List<ProductDTO> productsCarList = new ArrayList<ProductDTO>();

        for (ProductDTO product : productsList) {
            for (Long productId : cart.getProductsId()) {
                if (productId.equals(product.getProductId())) {
                    productsCarList.add(product);
                }
            }
        }

        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cart.getCartId());
        cartDTO.setTotal(cart.getTotal());
        cartDTO.setProductsList(productsCarList);

        return cartDTO;
    }

    public CartDTO fallbackGetCart (Throwable throwable) {
        return new CartDTO(999999L, 0.0, null);
    }
}
