package com.msteffen.aocweb.service

import java.io.File

interface InputService {

    fun getInputFileName(number: Int): String

    fun getInputFile(number: Int): File

    fun getInputs(number: Int): List<String>
}