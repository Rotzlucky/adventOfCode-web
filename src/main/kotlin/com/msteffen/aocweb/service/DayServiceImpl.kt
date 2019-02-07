package com.msteffen.aocweb.service

import com.msteffen.aocweb.solutions.Day
import com.msteffen.aocweb.solutions.year2018.Day1
import com.msteffen.aocweb.solutions.year2018.Day2
import org.springframework.stereotype.Component

@Component
class DayServiceImpl(val inputService: InputService) : DayService {

    private val days: ArrayList<Day> = ArrayList()

    init {
        addDay(Day1())
        addDay(Day2())
    }

    final override fun addDay(day: Day) {
        days.add(day)
    }

    override fun getAvailableDays(): List<Day> {
        return days
    }

    override fun getDay(number: Int): Day? {
        return days.find { it.number == number }
    }

    override fun solveDay(day: Day): List<String> {
        val inputs = inputService.getInputs(day.number)

        return listOf(
            day.solvePart1(inputs),
            day.solvePart2(inputs)
        )
    }
}