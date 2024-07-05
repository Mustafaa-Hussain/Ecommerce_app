package com.example.Ecommerce_app.controllers;


import com.example.Ecommerce_app.entites.Product;
import com.example.Ecommerce_app.entites.user.Role;
import com.example.Ecommerce_app.entites.user.User;
import com.example.Ecommerce_app.repositores.UserRepository;
import com.example.Ecommerce_app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products/")
public class ProductController {
    @Autowired
    private ProductService productService;

//     Get /products "Get all products"
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
//    Get /products/{productId} "Get product details"
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable(name = "productId") Integer id) throws ChangeSetPersister.NotFoundException {
        Product product = productService.getProductById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return ResponseEntity.ok().body(product);
    }

//    for admin users

//    Post /products "Add new product"
//    ensure that the user that create a new product is an admin user
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("admin")
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

//    Put /products/{productId} "Update product details"
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("admin/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable(name = "productId") Integer id, @RequestBody Product updatedProduct) throws Exception {
        return ResponseEntity.ok().body(productService.updateProduct(id, updatedProduct));
    }

//    Delete /products/{productId} "Delete product"
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("admin/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "productId") Integer id) throws Exception {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
