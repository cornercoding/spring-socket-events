package com.abnamro.pom.midoffice.event.http;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {
    @Bean
    public RestTemplate createRestClient() {
        return new RestTemplate();
    }

}
