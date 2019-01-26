package com.msteffen.aocweb

import com.msteffen.aocweb.solutions.Day
import com.msteffen.aocweb.solutions.year2018.Day1
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class)
@WebMvcTest
class AocApiControllerTests(@Autowired val mockMvc: MockMvc) {

    @Test
    fun `puzzle route returns list of Days`() {
        val aDay = Day1(1, "Some title")
        val anotherDay = Day1(1, "Another title")
        Day.addDay(aDay)
        Day.addDay(anotherDay)
        mockMvc.perform(MockMvcRequestBuilders.get("/api/puzzle/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("\$.[0].number").value(aDay.number))
                .andExpect(MockMvcResultMatchers.jsonPath("\$.[0].title").value(aDay.title))
                .andExpect(MockMvcResultMatchers.jsonPath("\$.[1].number").value(anotherDay.number))
                .andExpect(MockMvcResultMatchers.jsonPath("\$.[1].title").value(anotherDay.title))
    }

    @Test
    fun `translation route returns map of translations`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/i18n/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("\$.title").value("Advent of Code"))
    }

    @AfterAll
    fun teardown() {
        Day.removeAllDays()
    }

}