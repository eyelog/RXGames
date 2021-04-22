package ru.eyelog.rxgames.module004concat

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Single

class Module004Presenter : MvpPresenter<Module004View>(){

    fun getSingleConcat(){
        val firstEmitter = Single.just("First")
        val secondEmitter = Single.just("Second")

    }
}