package com.org.orm_spring_data.web;

import com.org.orm_spring_data.dao.ProductRepository;
import com.org.orm_spring_data.entities.Product;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
