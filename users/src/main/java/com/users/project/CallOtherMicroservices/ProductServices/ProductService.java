package com.users.project.CallOtherMicroservices.ProductServices;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final WebClient webClient;

    public ProductService(@Qualifier("productWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getAllProducts() {
        return webClient.get()
                .uri("/api/products/getAllProducts")
                .retrieve()
                .bodyToMono(String.class);
    }
}
