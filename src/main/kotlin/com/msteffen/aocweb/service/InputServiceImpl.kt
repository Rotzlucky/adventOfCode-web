package com.msteffen.aocweb.service

import java.io.File

class InputServiceImpl: InputService {

    override fun getInputFileName(number: Int): String {
        return "puzzle/year2018/Day$number.input"
    }

    override fun getInputFile(number: Int): File {
        return File(ClassLoader.getSystemResource(getInputFileName(number)).file)
    }

    override fun getInputs(number: Int): List<String> {
        val list = ArrayList<String>()
        getInputFile(number).forEachLine {list.add(it)}
        return list
    }
}