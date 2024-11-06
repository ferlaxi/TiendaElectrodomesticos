package com.project.products_service.service;

import com.project.products_service.model.Product;

import java.util.List;

public interface IProductService {
    public void createProduct(Product product);
    public List<Product> findProducts();
    public void editProduct(Long productId, Product editedProduct);
    public void deleteProduct(Long productId);
    public Product findProduct(Long productId);
}
