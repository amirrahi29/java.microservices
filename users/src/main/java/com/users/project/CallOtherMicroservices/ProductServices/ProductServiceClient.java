package com.users.project.CallOtherMicroservices.ProductServices;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceClient {

    private final WebClient.Builder webClientBuilder;

    public ProductServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<String> getAllProducts() {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8002/api/products/getAllProducts") // Replace with actual User Service URL
                .retrieve()
                .bodyToMono(String.class);
    }
}
