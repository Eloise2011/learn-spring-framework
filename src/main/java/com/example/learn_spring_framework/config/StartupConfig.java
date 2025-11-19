package com.example.learn_spring_framework.config;

/**
 * @author Joshua.H.Brooks
 * @description 用来调试控制器映射问题 开发环境使用，生产环境移除
 * @date 2025-11-18 11:16
 */
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class StartupConfig {

    @Bean
    public CommandLineRunner checkMappings(ApplicationContext ctx) {
        return args -> {
            System.out.println("=== 检查 Spring MVC 映射 ===");
            try {
                var handlerMapping = ctx.getBean(RequestMappingHandlerMapping.class);
                var mappings = handlerMapping.getHandlerMethods();

                System.out.println("已注册的端点数量: " + mappings.size());
                mappings.forEach((key, value) -> {
                    System.out.println("映射: " + key + " -> " + value);
                });

            } catch (Exception e) {
                System.err.println("检查映射时出错: " + e.getMessage());
            }
        };
    }
}
