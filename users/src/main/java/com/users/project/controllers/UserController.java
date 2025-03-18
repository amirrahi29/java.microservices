package com.users.project.controllers;

import com.users.project.CallOtherMicroservices.BlogServices.BlogServiceClient;
import com.users.project.CallOtherMicroservices.ProductServices.ProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final ProductServiceClient productServiceClient;
    private final BlogServiceClient blogServiceClient;

    @Autowired // Fixing the injection issue
    public UserController(ProductServiceClient productServiceClient, BlogServiceClient blogServiceClient) {
        this.productServiceClient = productServiceClient;
        this.blogServiceClient = blogServiceClient;
    }

    @GetMapping("")
    public String blog(){
        return "my user dashboard";
    }

    @GetMapping("/getAllUsers")
    public List<String> getAllProducts(){
        return List.of("user1","user2","user3","user4","user5");
    }

    @GetMapping("/getAllUsersProducts")
    public Mono<String> getAllUsersProducts(){
        return productServiceClient.getAllProducts();
    }

    @GetMapping("/getAllUsersBlogs")
    public Mono<String> getAllUsersBlogs(){
        return blogServiceClient.getAllBlogs();
    }

}
