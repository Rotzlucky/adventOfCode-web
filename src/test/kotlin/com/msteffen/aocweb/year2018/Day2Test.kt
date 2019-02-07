package com.msteffen.aocweb.year2018

import com.msteffen.aocweb.service.InputServiceImpl
import com.msteffen.aocweb.solutions.year2018.day1.Day1
import com.msteffen.aocweb.solutions.year2018.day2.Box
import com.msteffen.aocweb.solutions.year2018.day2.Day2
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class Day2Test {

    @Test
    fun `Assert Day2 of 2018 returns the correct solution`() {
        val day2 = Day2(2, ArgumentMatchers.anyString())
        val inputs = InputServiceImpl().getInputs(2)

        assertThat(day2.solvePart1(inputs)).isEqualTo("5704")
        assertThat(day2.solvePart2(inputs)).isEqualTo("umdryabviapkozistwcnihjqx")
    }

    @Test
    fun `Assert Day2 of 2018 returns the correct solution for test input`() {
        val day2 = Day2()

        var inputs = listOf(
                "abcdef",
                "bababc",
                "abbcde",
                "abcccd",
                "aabcdd",
                "abcdee",
                "ababab"
        )
        Assertions.assertThat(day2.solvePart1(inputs)).isEqualTo("12")
    }

    @Test
    fun `Assert that test ID 'abcdef' contains no Letter two or three times`() {
        val box = Box("abcdef")
        assertFalse(box.containsAnyLetterTwice())
        assertFalse(box.containsAnyLetterThreefold())
    }

    @Test
    fun `Assert that test ID 'bababc' contains double and threefold letters`() {
        val box = Box("bababc")
        assertTrue(box.containsAnyLetterTwice())
        assertTrue(box.containsAnyLetterThreefold())
    }

    @Test
    fun `Assert that test IDs contain double but no threefold letters`() {
        val box = Box("abbcde")
        assertTrue(box.containsAnyLetterTwice())
        assertFalse(box.containsAnyLetterThreefold())

        val box2 = Box("aabcdd")
        assertTrue(box2.containsAnyLetterTwice())
        assertFalse(box2.containsAnyLetterThreefold())

        val box3 = Box("abcdee")
        assertTrue(box3.containsAnyLetterTwice())
        assertFalse(box3.containsAnyLetterThreefold())
    }

    @Test
    fun `Assert that test IDs contain threefold but no double letters`() {
        val box = Box("abcccd")
        assertFalse(box.containsAnyLetterTwice())
        assertTrue(box.containsAnyLetterThreefold())

        val box2 = Box("ababab")
        assertFalse(box2.containsAnyLetterTwice())
        assertTrue(box2.containsAnyLetterThreefold())
    }
}