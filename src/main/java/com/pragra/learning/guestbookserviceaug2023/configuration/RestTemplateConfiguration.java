package com.pragra.learning.guestbookserviceaug2023.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestTemplateConfiguration {
    @Bean
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient getWebClient() { return WebClient.builder().build(); }
}
