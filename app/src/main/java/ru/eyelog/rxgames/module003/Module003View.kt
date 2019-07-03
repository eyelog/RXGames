package ru.eyelog.rxgames.module003

import com.arellomobile.mvp.MvpView
import ru.eyelog.rxgames.utils.ObjOutCome

interface Module003View : MvpView{

    fun setFlatMapNumbers(numbers: List<String>)

    fun setOutcomeObject(obj: ObjOutCome)

    fun setFlatMapListNumbers(numbers: List<String>)

    fun setFlatMapTwoListsNumbers(numbers: List<String>)
}