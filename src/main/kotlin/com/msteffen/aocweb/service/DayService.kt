package com.msteffen.aocweb.service

import com.msteffen.aocweb.solutions.Day

interface DayService {
    fun addDay(day: Day)

    fun getAvailableDays(): List<Day>

    fun getDay(number: Int): Day?

    fun solveDay(day: Day): List<String>
}