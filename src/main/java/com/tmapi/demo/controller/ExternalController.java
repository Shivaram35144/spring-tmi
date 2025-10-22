package com.tmapi.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/external")
public class ExternalController {

    private final WebClient webClient;
    private final String apiKey;

    public ExternalController(WebClient.Builder webClientBuilder,
                              @Value("${api.external.url}") String baseUrl,
                              @Value("${api.external.api-key}") String apiKey) {
        this.apiKey = apiKey;
        this.webClient = webClientBuilder
                .baseUrl(baseUrl)
                .build();
    }

    @GetMapping("/quotes")
    public Mono<ResponseEntity<String>> getQuote() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.build())  // no additional path needed, just /v1/quotes from baseUrl
                .header("X-Api-Key", apiKey)
                .retrieve()
                .bodyToMono(String.class)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.internalServerError()
                        .body("Failed to fetch quote. Please try again later."));
    }
}
