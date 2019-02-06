package com.msteffen.aocweb

import org.assertj.core.api.Assertions.assertThat
import com.msteffen.aocweb.solutions.Day
import com.msteffen.aocweb.solutions.InputService
import com.msteffen.aocweb.solutions.year2018.Day1
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class DayTest {

    @Test
    fun `Assert calling the add function adds the given object to the list`() {
        assertThat(Day.getAvailableDays().size).isEqualTo(0)

        val day1 = Day1(1, "A serious title")
        Day.addDay(day1)

        val availableDays = Day.getAvailableDays()
        assertThat(availableDays.size).isEqualTo(1)

        val day = availableDays[0]
        assertThat(day).isEqualTo(day1)
        assertThat(day.number).isEqualTo(1)
        assertThat(day.title).isEqualTo("A serious title")
    }

    @Test
    fun `Assert that the fileName is constructed with the number parameter`() {
        val inputService = InputService()

        assertThat(inputService.getInputFileName(6)).isEqualTo("puzzle/year2018/Day6.input")
        assertThat(inputService.getInputFileName(13)).isEqualTo("puzzle/year2018/Day13.input")
    }

    @Test
    fun `Assert that a file for a fileName is returned`() {
        val inputService = InputService()
        val inputFile = inputService.getInputFile(1)
        assertThat(inputFile).exists()
        assertThat(inputFile).isFile()
        assertThat(inputFile).hasName("Day1.input")
    }

    @Test
    fun `Assert that file content is put in Array`() {
        val aDay = Day1(1, ArgumentMatchers.anyString())
        val inputService = InputService()
        val inputFile = inputService.getInputFile(1)
        var count = 0
        inputFile.forEachLine { count++ }
        assertThat(aDay.getInputs()).isNotEmpty
        assertThat(aDay.getInputs()).hasSize(count)
    }
}