package com.msteffen.aocweb.year2018

import com.msteffen.aocweb.solutions.InputService
import com.msteffen.aocweb.solutions.year2018.Day1
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest
class Day1Test {

    @Test
    fun `Assert Day1 of 2018 returns the correct solution`() {
        val day1 = Day1(1, ArgumentMatchers.anyString())

        Assertions.assertThat(day1.solvePart1()).isEqualTo("520")
        Assertions.assertThat(day1.solvePart2()).isEqualTo("394")
    }

    @Test
    fun `Assert Day1 of 2018 returns the correct solution for test input`() {
        val day1 = Day1()
        val number = day1.number
        val inputService: InputService = mock()
        day1.inputService = inputService

        whenever(inputService.getInputs(number)).thenReturn(Arrays.asList("+1", "-2", "+3", "+1"))
        Assertions.assertThat(day1.solvePart1()).isEqualTo("3")
        Assertions.assertThat(day1.solvePart2()).isEqualTo("2")

        whenever(inputService.getInputs(number)).thenReturn(Arrays.asList("+1", "+1", "+1"))
        Assertions.assertThat(day1.solvePart1()).isEqualTo("3")

        whenever(inputService.getInputs(number)).thenReturn(Arrays.asList("+1", "+1", "-2"))
        Assertions.assertThat(day1.solvePart1()).isEqualTo("0")

        whenever(inputService.getInputs(number)).thenReturn(Arrays.asList("-1", "-2", "-3"))
        Assertions.assertThat(day1.solvePart1()).isEqualTo("-6")

        whenever(inputService.getInputs(number)).thenReturn(Arrays.asList("+1", "-1"))
        Assertions.assertThat(day1.solvePart2()).isEqualTo("0")

        whenever(inputService.getInputs(number)).thenReturn(Arrays.asList("+3", "+3", "+4", "-2", "-4"))
        Assertions.assertThat(day1.solvePart2()).isEqualTo("10")

        whenever(inputService.getInputs(number)).thenReturn(Arrays.asList("-6", "+3", "+8", "+5", "-6"))
        Assertions.assertThat(day1.solvePart2()).isEqualTo("5")

        whenever(inputService.getInputs(number)).thenReturn(Arrays.asList("+7", "+7", "-2", "-7", "-4"))
        Assertions.assertThat(day1.solvePart2()).isEqualTo("14")
    }

}