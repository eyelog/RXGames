package ru.eyelog.rxgames.module001

import kotlin.random.Random

class MockNumbers{

    companion object{
        fun generateList():List<Int>{

            val numbers = ArrayList<Int>()
            for (i in 0..7){
                numbers.add((0..300).random())
            }
            return numbers
        }
    }
}