package com.msteffen.aocweb

import com.msteffen.aocweb.service.InputServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest
class InputServiceTests {

    val inputService = InputServiceImpl()

    @Test
    fun `Assert that the fileName is constructed with the number parameter`() {
        assertThat(inputService.getInputFileName(6)).isEqualTo("puzzle/year2018/Day6.input")
        assertThat(inputService.getInputFileName(13)).isEqualTo("puzzle/year2018/Day13.input")
    }

    @Test
    fun `Assert that a file for a fileName is returned`() {
        val inputFile = inputService.getInputFile(1)
        assertThat(inputFile).exists()
        assertThat(inputFile).isFile()
        assertThat(inputFile).hasName("Day1.input")
    }

    @Test
    fun `Assert that file content is put in Array`() {
        val inputFile = inputService.getInputFile(1)
        var count = 0
        inputFile.forEachLine { count++ }
        assertThat(inputService.getInputs(1)).isNotEmpty
        assertThat(inputService.getInputs(1)).hasSize(count)
    }
}
