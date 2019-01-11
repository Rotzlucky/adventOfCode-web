package com.msteffen.aocweb.controller

import com.msteffen.aocweb.AocProperties
import com.msteffen.aocweb.solutions.Day
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController(private val properties: AocProperties) {

    @GetMapping("/")
    fun aocWeb(model: Model): String {
        model["i18n"] = properties.i18n
        model["cssPath"] = properties.cssPath
        model["days"] = Day.getAvailableDays()
        return "aoc"
    }
}