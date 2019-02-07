package com.msteffen.aocweb

import com.msteffen.aocweb.service.DayService
import com.msteffen.aocweb.service.DayServiceImpl
import com.msteffen.aocweb.service.InputService
import com.msteffen.aocweb.service.InputServiceImpl
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableConfigurationProperties
class AocWebApplication {
    @Bean
    fun inputService(): InputService {
        return InputServiceImpl()
    }

    @Bean
    fun dayService(): DayService {
        return DayServiceImpl(inputService())
    }
}

fun main(args: Array<String>) {
    runApplication<AocWebApplication>(*args)
}