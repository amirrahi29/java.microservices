package com.users.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder().filter(filterFunction);
    }

    @Bean
    public WebClient blogWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl("http://blogs").build();
    }

    @Bean
    public WebClient productWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl("http://products").build();
    }
}
