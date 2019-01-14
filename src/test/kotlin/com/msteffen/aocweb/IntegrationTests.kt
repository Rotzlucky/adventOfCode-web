package com.msteffen.aocweb

import com.msteffen.aocweb.solutions.Day
import com.msteffen.aocweb.solutions.year2018.Day1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

    @BeforeAll
    fun setup() {
        println(">> Setup")
        Day.addDay(Day1(1, "Chronal Calibration"))
    }

    @Test
    fun `Assert aoc page title, content and status code`() {
        val entity = restTemplate.getForEntity<String>("/")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("<h1>Advent of Code</h1>", "calendar-grid")
    }

    @Test
    fun `Assert Day1 page title, content and status code`() {
        val entity = restTemplate.getForEntity<String>("/2018/day/1")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("Chronal Calibration")
    }

    @Test
    fun `Assert non existing day returns 404`() {
        val entity = restTemplate.getForEntity<String>("/2018/day/32")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }

}