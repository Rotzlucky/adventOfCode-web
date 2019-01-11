package com.msteffen.aocweb.solutions

abstract class Day(val number: Int, val title: String) {

    abstract fun solvePart1()

    abstract fun solvePart2()

    companion object {
        private val days: ArrayList<Day> = ArrayList()

        fun addDay(day: Day) {
            days.add(day)
        }

        fun getAvailableDays(): List<Day> {
            return days
        }
    }
}