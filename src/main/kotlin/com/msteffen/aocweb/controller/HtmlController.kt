package com.msteffen.aocweb.controller

import com.msteffen.aocweb.solutions.Day
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

    @GetMapping("/")
    fun aocWeb(model: Model): String {
        model["title"] = "Advent of Code"
        model["days"] = Day.getAvailableDays()
        return "aoc"
    }
}