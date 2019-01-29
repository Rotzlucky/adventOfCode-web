package com.msteffen.aocweb.controller

import com.msteffen.aocweb.AocResourceBundleMessageSource
import com.msteffen.aocweb.NonExistingDayException
import com.msteffen.aocweb.solutions.Day
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api")
class AocApiController(val resourceBundleMessageSource: AocResourceBundleMessageSource) {

    @GetMapping("/puzzle")
    fun findAll(): List<Day> {
        return Day.getAvailableDays()
    }

    @GetMapping("/puzzle/{number}")
    fun find(@PathVariable number: Int): Day {
        return Day.getDay(number) ?: throw NonExistingDayException()
    }

    @GetMapping("/solution/{number}")
    fun calculate(@PathVariable number: Int): List<String> {
        val day = Day.getDay(number) ?: throw NonExistingDayException()
        return Arrays.asList(
                day.solvePart1(),
                day.solvePart2()
        )
    }

    @GetMapping("/i18n")
    fun getTranslations(@RequestParam(defaultValue = "en_GB") locale: Locale): HashMap<String, String> {
        return resourceBundleMessageSource.getTranslationMap(locale)
    }
}