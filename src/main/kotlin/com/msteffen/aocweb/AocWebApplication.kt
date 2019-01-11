package com.msteffen.aocweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(AocProperties::class)
class AocWebApplication

fun main(args: Array<String>) {
    runApplication<AocWebApplication>(*args)
}

