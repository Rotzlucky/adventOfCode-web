package com.msteffen.aocweb.solutions

class Day(val number: Int, val title: String) {
    companion object {
        fun getAvailableDays(): List<Day> {
            return listOf(
                    Day(1, "Chronal Calibration"),
                    Day(2, "Inventory Management System"),
                    Day(3, "No Matter How You Slice It"),
                    Day(4, "Repose Record"),
                    Day(5, "Alchemical Reduction"),
                    Day(6, "Chronal Coordinates"),
                    Day(7, "The Sum of Its Parts")
            )
        }
    }
}