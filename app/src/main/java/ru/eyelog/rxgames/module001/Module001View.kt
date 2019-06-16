package ru.eyelog.rxgames.module001

import com.arellomobile.mvp.MvpView

interface Module001View : MvpView{

    fun setRandomNumbers(numbers: List<Int>)

    fun setRangeNumbers(numbers: List<Int>)

    fun setIntervalNumbers(numbers: List<Int>)

    fun setFromCallableNumbers(numbers: List<Int>)

    fun setMapNumbers(numbers: List<String>)

    fun setBufferNumbers(numbers: List<String>)
}