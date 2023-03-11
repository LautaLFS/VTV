package com.certantchallenge.vtv.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

@Component
public class AppConfigs {
    @Configuration
    public static class AppConfig {

        @Bean
        public Jackson2ObjectMapperBuilder jacksonBuilder() {
            Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
            builder.serializationInclusion(JsonInclude.Include.NON_NULL);
            return builder;
        }

    }
}
