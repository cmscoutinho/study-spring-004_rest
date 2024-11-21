package med.voll.api.controller.cors;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class CorsConfiguration {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
