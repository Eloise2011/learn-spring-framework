package com.example.learn_spring_framework.config;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-18 11:33
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class WebMvcConfig {

    // 确保主要的 RequestMappingHandlerMapping 被优先使用
    @Bean
    @Primary
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping();
    }
}
