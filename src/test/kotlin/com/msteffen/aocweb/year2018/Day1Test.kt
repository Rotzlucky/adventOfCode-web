package com.msteffen.aocweb.year2018

import com.msteffen.aocweb.solutions.year2018.Day1
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

        Assertions.assertThat(day1.solvePart1()).isEqualTo("520")
        Assertions.assertThat(day1.solvePart2()).isEqualTo("394")
    }
}