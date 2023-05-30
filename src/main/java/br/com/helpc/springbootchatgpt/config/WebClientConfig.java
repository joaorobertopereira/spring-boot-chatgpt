package br.com.helpc.springbootchatgpt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${openai.urlBase}")
    private String urlBase;

    @Value("${openai.apiKey}")
    private String apiKey;

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl(urlBase)
                .defaultHeader("Content-Type","application/json")
                .defaultHeader("Authorization",String.format("Bearer %s",apiKey))
                .build();
    }
}
