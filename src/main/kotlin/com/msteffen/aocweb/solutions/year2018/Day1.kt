package com.msteffen.aocweb.solutions.year2018

import com.msteffen.aocweb.solutions.Day

class Day1(number: Int, title: String) : Day(number, title) {
    override fun solvePart1(): String {
        return getInputs().fold(0) { total, next -> total + next.toInt() }.toString()
    }

    override fun solvePart2(): String {
        val inputs = getInputs()
        val seenFrequencies = HashSet<Int>()
        var frequency = 0
        do {
            for (input in inputs) {
                frequency += input.toInt()

                if (seenFrequencies.contains(frequency)) {
                    return frequency.toString()
                }

                seenFrequencies.add(frequency)
            }
        } while (true)
    }
}