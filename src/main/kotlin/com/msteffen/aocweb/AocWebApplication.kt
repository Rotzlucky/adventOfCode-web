package com.msteffen.aocweb

import com.msteffen.aocweb.solutions.Day
import com.msteffen.aocweb.solutions.year2018.Day1
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(AocProperties::class)
class AocWebApplication {}

fun main(args: Array<String>) {
    runApplication<AocWebApplication>(*args)
    Day.addDay(Day1(1, "Chronal Calibration"))
    Day.addDay(Day1(2, "Inventory Management System"))
    Day.addDay(Day1(3, "No Matter How You Slice It"))
    Day.addDay(Day1(4, "Repose Record"))
    Day.addDay(Day1(5, "Alchemical Reduction"))
    Day.addDay(Day1(6, "Chronal Coordinates"))
    Day.addDay(Day1(7, "The Sum of Its Parts"))
}