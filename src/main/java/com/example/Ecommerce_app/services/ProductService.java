package com.example.Ecommerce_app.services;


import com.example.Ecommerce_app.entites.Product;
import com.example.Ecommerce_app.repositores.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addNewProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(Integer id) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found for this id :: " + id));
        productRepository.delete(product);
    }

    public Product updateProduct(Integer id, Product updatedProduct) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found for this id :: " + id));

        if(product.getId() == id){
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setCategory(updatedProduct.getCategory());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            product.setImageUrl(updatedProduct.getImageUrl());
        }
        return productRepository.save(product);
    }
}
