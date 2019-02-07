package com.msteffen.aocweb.year2018

import com.msteffen.aocweb.service.InputServiceImpl
import com.msteffen.aocweb.solutions.year2018.day1.Day1
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class Day1Test {

    @Test
    fun `Assert Day1 of 2018 returns the correct solution`() {
        val day1 = Day1(1, ArgumentMatchers.anyString())
        val inputs = InputServiceImpl().getInputs(1)

        Assertions.assertThat(day1.solvePart1(inputs)).isEqualTo("520")
        Assertions.assertThat(day1.solvePart2(inputs)).isEqualTo("394")
    }

    @Test
    fun `Assert Day1 of 2018 returns the correct solution for test input`() {
        val day1 = Day1()

        var inputs = listOf("+1", "-2", "+3", "+1")
        Assertions.assertThat(day1.solvePart1(inputs)).isEqualTo("3")
        Assertions.assertThat(day1.solvePart2(inputs)).isEqualTo("2")

        inputs = listOf("+1", "+1", "+1")
        Assertions.assertThat(day1.solvePart1(inputs)).isEqualTo("3")

        inputs = listOf("+1", "+1", "-2")
        Assertions.assertThat(day1.solvePart1(inputs)).isEqualTo("0")

        inputs = listOf("-1", "-2", "-3")
        Assertions.assertThat(day1.solvePart1(inputs)).isEqualTo("-6")

        inputs = listOf("+1", "-1")
        Assertions.assertThat(day1.solvePart2(inputs)).isEqualTo("0")

        inputs = listOf("+3", "+3", "+4", "-2", "-4")
        Assertions.assertThat(day1.solvePart2(inputs)).isEqualTo("10")

        inputs = listOf("-6", "+3", "+8", "+5", "-6")
        Assertions.assertThat(day1.solvePart2(inputs)).isEqualTo("5")

        inputs = listOf("+7", "+7", "-2", "-7", "-4")
        Assertions.assertThat(day1.solvePart2(inputs)).isEqualTo("14")
    }

}