package com.sierraazul.controlpagosapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir CORS en todas las rutas
            .allowedOrigins("*") // Permitir desde cualquier origen
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Métodos HTTP permitidos
    }
}