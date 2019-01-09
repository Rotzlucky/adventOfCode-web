package com.msteffen.aocweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AocWebApplication

fun main(args: Array<String>) {
    runApplication<AocWebApplication>(*args)
}

