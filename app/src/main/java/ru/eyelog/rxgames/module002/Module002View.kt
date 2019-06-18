package ru.eyelog.rxgames.module002

import com.arellomobile.mvp.MvpView

interface Module002View : MvpView{

    fun setColdLeftNumbers(numberLeft: String)

    fun setColdRightNumbers(numberRight: String)

    fun setHotLeftNumbers(numberLeft: String)

    fun setHotRightNumbers(numberRight: String)

    fun setReplayLeftNumbers(numberLeft: String)

    fun setReplayRightNumbers(numberRight: String)

    fun setRefCountLeftNumbers(numberLeft: String)

    fun setRefCountRightNumbers(numberRight: String)

    fun setCacheLeftNumbers(numberLeft: String)

    fun setCacheRightNumbers(numberRight: String)

}