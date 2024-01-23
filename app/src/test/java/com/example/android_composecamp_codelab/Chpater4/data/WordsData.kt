package com.example.android_composecamp_codelab.Chpater4.data

const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20

// List with all the words for the Game
val allWords: Set<String> =
    setOf(
        "at",
        "sea",
        "arise",
        "banana",
        "home",
        "birthday",
        "briefcase",
        "motorcycle",
        "cauliflower",
        "android"
    )

private val wordLengthMap: Map<Int, String> = allWords.associateBy({ it.length }, { it })

internal fun getUnscrambledWord(scrambledWord: String) = wordLengthMap[scrambledWord.length] ?: ""