package com.msteffen.aocweb.solutions

abstract class Day(val number: Int, val title: String) {
    abstract fun solvePart1(inputs: List<String>): String

    abstract fun solvePart2(inputs: List<String>): String
}