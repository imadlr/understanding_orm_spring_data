package com.org.orm_spring_data;

import com.org.orm_spring_data.dao.ProductRepository;
import com.org.orm_spring_data.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmSpringDataApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmSpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // productRepository.save(new Product(null, "Computer", 3400, 3));
        // productRepository.save(new Product(null, "Printer", 400, 7));
        // productRepository.save(new Product(null, "TV", 34000, 6));
        // productRepository.save(new Product(null, "Smart TV", 50000, 4));
        List<Product> products = productRepository.findAll();
        System.out.println("$$$$$$$$$$$$$$");
        System.out.println("Find All Products :");
        products.forEach(product -> {
            System.out.println(product.toString());
        });
        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println("$$$$$$$$$$$$$$");
        System.out.println("Find Product By Id :");
        System.out.println(product.toString());
        System.out.println("$$$$$$$$$$$$$$");
        System.out.println("Find Product By Name :");
        List<Product> productsByName = productRepository.findByNameContains("c");
        productsByName.forEach(prod -> {
            System.out.println(prod.toString());
        });
    }
}