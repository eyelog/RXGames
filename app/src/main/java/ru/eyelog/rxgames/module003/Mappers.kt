package ru.eyelog.rxgames.module003

import io.reactivex.FlowableTransformer
import io.reactivex.rxkotlin.toFlowable


val composer = FlowableTransformer<List<Int>, List<String>> {
    it.flatMap {
        it.toFlowable()
            .map{
                "Number is $it"
            }
            .toList()
            .toFlowable()
    }
}