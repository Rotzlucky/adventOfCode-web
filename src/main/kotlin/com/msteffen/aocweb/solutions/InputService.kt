package com.msteffen.aocweb.solutions

import java.io.File

open class InputService {

    fun getInputFileName(number: Int): String {
        return "puzzle/year2018/Day$number.input"
    }

    fun getInputFile(number: Int): File {
        return File(ClassLoader.getSystemResource(getInputFileName(number)).file)
    }

    open fun getInputs(number: Int): List<String> {
        val list = ArrayList<String>()
        getInputFile(number).forEachLine {list.add(it)}
        return list
    }
}