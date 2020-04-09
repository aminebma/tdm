package com.example.exo3

import kotlin.random.Random

class WordGenerator(val wordsList:MutableList<String>) {
    fun generateWord():String = wordsList[Random.nextInt(0,wordsList.size)]
}