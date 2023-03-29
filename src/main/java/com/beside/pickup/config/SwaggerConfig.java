package com.beside.pickup.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// SwaggerConfig.java
@OpenAPIDefinition(
        info = @Info(title = "줍깅 API 명세서",
                description = "줍깅 API 명세서",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {
 
    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"/v1/**"};
 
        return GroupedOpenApi.builder()
                .group("줍깅 API v1")
                .pathsToMatch(paths)
                .build();
    }
}