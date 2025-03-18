package com.products.project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping("")
    public String blog(){
        return "my product dashboard";
    }

    @GetMapping("/getAllProducts")
    public List<String> getAllProducts(){
        return List.of("product1","product2","product3","product4","product5");
    }

}
