package com.users.project.CallOtherMicroservices.BlogServices;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BlogService {

    private final WebClient webClient;

    public BlogService(@Qualifier("blogWebClient") WebClient webClient) {  // ✅ Specify which WebClient to use
        this.webClient = webClient;
    }

    public Mono<String> getAllBlogs() {
        return webClient.get()
                .uri("/api/blogs/getAllBlogs")
                .retrieve()
                .bodyToMono(String.class);
    }
}
