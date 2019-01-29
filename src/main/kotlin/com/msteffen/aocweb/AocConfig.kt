package com.msteffen.aocweb

import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.Locale
import kotlin.collections.HashMap

@Configuration
class CorsConfigurer: WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/api/**").allowedOrigins("http://localhost:3000")
    }
}

class AocResourceBundleMessageSource: ResourceBundleMessageSource() {
    fun getTranslationMap(locale: Locale): HashMap<String, String> {
        val resourceBundle = getResourceBundle("message", locale)
        val keySet = resourceBundle?.keySet()

        val map = HashMap<String, String>()
        keySet?.forEach { map[it] = resourceBundle.getString(it) }

        return map
    }
}