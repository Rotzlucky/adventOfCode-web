package com.msteffen.aocweb

import org.assertj.core.api.Assertions.assertThat
import com.msteffen.aocweb.solutions.Day
import com.msteffen.aocweb.solutions.year2018.Day1
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
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
}