package com.msteffen.aocweb.solutions.year2018.day2

import com.msteffen.aocweb.solutions.Day

class Day2(number: Int = 2, title: String = "Inventory Management System") : Day(number, title) {
    override fun solvePart1(inputs: List<String>): String {
        val boxes = ArrayList<Box>()
        inputs.forEach { boxes += Box(it) }

        return (boxes.count{it.containsAnyLetterTwice()} * boxes.count{it.containsAnyLetterThreefold()}).toString()
    }

    override fun solvePart2(inputs: List<String>): String {
        return ""
    }
}