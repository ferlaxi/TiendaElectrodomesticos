package com.project.products_service.service;

import com.project.products_service.model.Product;
import com.project.products_service.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepo;

    @Override
    public void createProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<Product> findProducts() {
        return productRepo.findAll();
    }

    @Override
    public void editProduct(Long productId, Product editedProduct) {
        Product product = productRepo.findById(productId).orElse(null);

        product.setProductName(editedProduct.getProductName());
        product.setProductBrand(editedProduct.getProductBrand());
        product.setProductPrice(editedProduct.getProductPrice());

        productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public Product findProduct(Long productId) {
        return productRepo.findById(productId).orElse(null);
    }
}
