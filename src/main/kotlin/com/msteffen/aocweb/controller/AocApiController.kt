package com.msteffen.aocweb.controller

import com.msteffen.aocweb.NonExistingDayException
import com.msteffen.aocweb.service.DayService
import com.msteffen.aocweb.solutions.Day
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AocApiController(val dayService: DayService) {

    @GetMapping("/puzzle")
    fun findAll(): List<Day> {
        return dayService.getAvailableDays()
    }

    @GetMapping("/puzzle/{number}")
    fun find(@PathVariable number: Int): Day {
        return dayService.getDay(number) ?: throw NonExistingDayException()
    }

    @GetMapping("/solution/{number}")
    fun solve(@PathVariable number: Int): List<String> {
        val day = dayService.getDay(number) ?: throw NonExistingDayException()
        return dayService.solveDay(day)
    }
}