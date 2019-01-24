package com.msteffen.aocweb

import com.msteffen.aocweb.solutions.Day
import com.msteffen.aocweb.solutions.year2018.Day1
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableConfigurationProperties
class AocWebApplication {
    @Bean
    fun resourceBundleMessageSource(): AocResourceBundleMessageSource {
        return AocResourceBundleMessageSource()
    }
}

fun main(args: Array<String>) {
    runApplication<AocWebApplication>(*args)
    Day.addDay(Day1())
}