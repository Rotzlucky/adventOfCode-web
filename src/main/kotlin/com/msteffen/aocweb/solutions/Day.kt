package com.msteffen.aocweb.solutions

abstract class Day(val number: Int, val title: String) {

    var inputService = InputService()

    fun getInputs(): List<String> {
        return inputService.getInputs(number)
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

        fun removeAllDays() {
            days.clear()
        }
    }
}