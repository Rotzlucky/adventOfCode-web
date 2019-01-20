package com.msteffen.aocweb.controller

import com.msteffen.aocweb.solutions.Day
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/puzzle")
class AocApiController {

    @GetMapping("/")
    fun findAll(): List<Day> {
        return Day.getAvailableDays()
    }
}