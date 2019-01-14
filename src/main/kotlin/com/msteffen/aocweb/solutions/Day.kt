package com.msteffen.aocweb.solutions

import java.io.File

abstract class Day(val number: Int, val title: String) {

    fun getInputFileName(): String {
        return "puzzle/year2018/Day$number.input"
    }

    fun getInputFile(): File {
        return File(ClassLoader.getSystemResource(getInputFileName()).file)
    }

    fun getInputs(): ArrayList<String> {
        val list = ArrayList<String>()
        getInputFile().forEachLine {list.add(it)}
        return list
    }

    abstract fun solvePart1(): String

    abstract fun solvePart2(): String

    companion object {
        private val days: ArrayList<Day> = ArrayList()

        fun addDay(day: Day) {
            days.add(day)
        }

        fun getAvailableDays(): List<Day> {
            return days
        }

        fun getDay(number: Int): Day? {
            return days.find { it.number == number }
        }
    }
}