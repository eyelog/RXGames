package ru.eyelog.rxgames.module001single

import com.arellomobile.mvp.MvpView

interface Module001SingleView : MvpView{

    fun setRandomNumbers(numbers: List<Int>)

    fun setRangeNumbers(numbers: List<Int>)

    fun setIntervalNumbers(numbers: List<Int>)

    fun setFromCallableNumbers(numbers: List<Int>)

    fun setMapNumbers(numbers: List<String>)

    fun setBufferNumbers(numbers: List<String>)

    fun setTakeNumbers(numbers: List<String>)

    fun setSkipNumbers(numbers: List<String>)

    fun setDistinctNumbers(numbers: List<String>)

    fun setFilterNumbers(numbers: List<String>)

    fun setMergeNumbers(numbers: List<String>)

    fun setZipNumbers(numbers: List<String>)

    fun setTakeUntilNumbers(numbers: List<String>)

    fun setAllNumbers(numbers: List<String>)
}