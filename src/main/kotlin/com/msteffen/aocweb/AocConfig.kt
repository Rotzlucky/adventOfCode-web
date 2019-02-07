package com.msteffen.aocweb

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfigurer: WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/api/**").allowedOrigins("http://localhost:3000")
    }
}

@Configuration
@ComponentScan("com.msteffen.aocweb.service")
class AocConfig