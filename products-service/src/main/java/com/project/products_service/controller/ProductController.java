package com.project.products_service.controller;

import com.project.products_service.model.Product;
import com.project.products_service.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productServ;

    @PostMapping("/create")
    ResponseEntity<String> createProduct(@RequestBody Product product) {
        productServ.createProduct(product);
        return new ResponseEntity<>("Product Created", HttpStatus.CREATED);
    }

    @GetMapping("/get")
    ResponseEntity<List<Product>> getProducts () {
        return new ResponseEntity<>(productServ.findProducts(), HttpStatus.OK);
    }

    @PutMapping("/edit/{productId}")
    ResponseEntity<String> editProduct (@PathVariable Long prodcutId,
                                        @RequestBody Product editedProduct) {
        productServ.editProduct(prodcutId, editedProduct);
        return new ResponseEntity<>("Product Edited", HttpStatus.OK);
    }

    @DeleteMapping("/delete/productId")
    ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        productServ.deleteProduct(productId);
        return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
    }

    @GetMapping("get/{productId}")
    ResponseEntity<Product> getProduct (@PathVariable Long productId) {
        return new ResponseEntity<>(productServ.findProduct(productId), HttpStatus.OK);
    }
}
