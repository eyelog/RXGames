package ru.eyelog.rxgames.module003

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.toFlowable
import io.reactivex.schedulers.Schedulers
import ru.eyelog.rxgames.utils.MockNumbers
import ru.eyelog.rxgames.utils.ObjIncome
import ru.eyelog.rxgames.utils.ObjOutCome
import java.util.concurrent.TimeUnit

@InjectViewState
class Module003Presenter : MvpPresenter<Module003View>(){

    fun getFlatMapNumbers(){

        val flowable = Flowable
            .intervalRange(1, 10, 1, 1, TimeUnit.SECONDS)
            .flatMap { Flowable.fromArray(MockNumbers.generateList(10)) }
            .compose(composer)

        flowable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewState.setFlatMapNumbers(it)
            }
            .addTo(CompositeDisposable())

    }

    fun getObjectNumbers(){
        val single = Single.just(MockNumbers.generateIncomeObject(15))

        single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                ObjOutCome(
                    it.num.toString(),
                    it.name,
                    it.numbers.flatMap {
                        listOf(it.toString())
                    }
                )
            }
            .subscribe({
                viewState.setOutcomeObject(it)
            },{
                // Catch a bug
            })
            .addTo(CompositeDisposable())
    }

    fun getFlatMapListNumbers(){


    }

    fun getFlatMapTwoListsNumbers(){

    }
}