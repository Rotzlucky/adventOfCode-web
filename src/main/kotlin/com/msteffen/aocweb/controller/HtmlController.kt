package com.msteffen.aocweb.controller

import com.msteffen.aocweb.AocProperties
import com.msteffen.aocweb.NonExistingDayException
import com.msteffen.aocweb.solutions.Day
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class HtmlController(private val properties: AocProperties) {

    @GetMapping("/")
    fun aocWeb(model: Model): String {
        model["i18n"] = properties.i18n
        model["cssPath"] = properties.cssPath
        model["days"] = Day.getAvailableDays()

        return "aoc"
    }

    @GetMapping("/2018/day/{number}")
    fun day(@PathVariable number: Int, model: Model): String {
        val day = Day.getDay(number) ?: throw NonExistingDayException()

        model["i18n"] = properties.i18n
        model["cssPath"] = properties.cssPath
        model["adventOfCodeBaseUrl"] = properties.adventOfCodeBaseUrl
        model["day"] = day

        return "day"
    }
}