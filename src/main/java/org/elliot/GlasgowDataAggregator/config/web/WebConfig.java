package org.elliot.GlasgowDataAggregator.config.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

    @Bean
    WebClient webClient() {
        return WebClient
                .builder()
                .build();
    }
}
