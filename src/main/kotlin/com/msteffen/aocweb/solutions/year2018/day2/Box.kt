package com.msteffen.aocweb.solutions.year2018.day2

class Box(val id:String) {

    private val charMap = HashMap<Char, Int>()

    init {
        id.toCharArray().forEach {
            charMap[it] = charMap.getOrDefault(it, 0) + 1
        }
    }

    fun containsAnyLetterTwice(): Boolean {
        return charMap.containsValue(2)
    }

    fun containsAnyLetterThreefold(): Boolean {
        return charMap.containsValue(3)
    }

    fun getCommonCharacters(other: Box): String {
        var commonCharacters = ""

        (0 until id.length).forEach {
            if (id[it] == other.id[it]) {
                commonCharacters += id[it]
            }
        }

        return commonCharacters
    }
}