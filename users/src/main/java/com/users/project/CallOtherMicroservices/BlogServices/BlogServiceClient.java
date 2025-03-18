package com.users.project.CallOtherMicroservices.BlogServices;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BlogServiceClient {

    private final WebClient.Builder webClientBuilder;

    public BlogServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<String> getAllBlogs() {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8001/api/blogs/getAllBlogs") // Replace with actual User Service URL
                .retrieve()
                .bodyToMono(String.class);
    }
}
