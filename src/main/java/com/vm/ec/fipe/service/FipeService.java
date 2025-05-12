package com.vm.ec.fipe.service;

import com.vm.ec.fipe.constants.fipeApiConstants;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ExchangeStrategies;

@Service
public class FipeService {

    private final WebClient webClient;

    public FipeService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl(fipeApiConstants.BASE_API_URL)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs()
                                .maxInMemorySize(10 * 1024 * 1024)) // Set buffer size to 10MB
                        .build())
                .build();
    }

    public String fetchAllMakes() {
        return webClient.get()
                .uri(fipeApiConstants.GET_BRANDS_URL)
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Blocking for simplicity; avoid in reactive applications
    }

}