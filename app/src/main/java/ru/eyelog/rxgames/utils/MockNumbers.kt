package ru.eyelog.rxgames.utils

import java.util.concurrent.TimeUnit

class MockNumbers{

    companion object{
        fun generateNumber():Int{
            return (0..300).random()
        }

        fun generateList():List<Int>{

            val numbers = ArrayList<Int>()
            for (i in 0..30){
                numbers.add((0..300).random())
            }
            return numbers
        }
    }
}