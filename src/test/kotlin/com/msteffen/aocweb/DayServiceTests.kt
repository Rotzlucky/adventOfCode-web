package com.msteffen.aocweb

import com.msteffen.aocweb.service.DayServiceImpl
import com.msteffen.aocweb.service.InputService
import com.msteffen.aocweb.solutions.year2018.day1.Day1
import com.nhaarman.mockito_kotlin.mock
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class DayServiceTests {

    val inputService: InputService = mock()

    @Test
    fun `Assert calling the add function adds the given object to the list`() {
        val dayService = DayServiceImpl(inputService)

        assertThat(dayService.getAvailableDays().size).isEqualTo(2)

        val day1 = Day1(1, "A serious title")
        dayService.addDay(day1)

        val availableDays = dayService.getAvailableDays()
        assertThat(availableDays.size).isEqualTo(3)

        val day = availableDays[2]
        assertThat(day).isEqualTo(day1)
        assertThat(day.number).isEqualTo(1)
        assertThat(day.title).isEqualTo("A serious title")
    }
}