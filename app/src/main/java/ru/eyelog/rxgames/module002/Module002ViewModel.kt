package ru.eyelog.rxgames.module002

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Observable
import io.reactivex.Scheduler
import java.util.concurrent.TimeUnit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

@InjectViewState
class Module002ViewModel : MvpPresenter<Module002View>(){

    // Каждый подписчик получает весь поток с первого до последнего элемента
    fun getColdNumbers(){

        // Создаём "холодный" генератор данных
        val observable = Observable
            .intervalRange(1, 15, 1, 1, TimeUnit.SECONDS)
            .map { it.toString() }

        // Первый подписчик подписывается через 1 секунду
        Handler().postDelayed({
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setColdLeftNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 1000)

        // Второй подписчик подписывается через 3,5 секунды
        Handler().postDelayed({
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setColdRightNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 3500)
    }

    // Каждый подписчик получает поток с того элемента с которого он подписался
    fun getHotNumbers(){

        // Создаём "горячий" генератор данных
        val observable = Observable
            .intervalRange(1, 15, 1, 1, TimeUnit.SECONDS)
            .map { it.toString() }
            .publish()

        // Стартуем поток
        observable.connect()

        // Первый подписчик подписывается через 2 секунды
        Handler().postDelayed({
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setHotLeftNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 2000)

        // Второй подписчик подписывается через 5,5 секунд
        Handler().postDelayed({
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setHotRightNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 5500)
    }

    // В момент подписки пропущенные эленменты из горячего потока передаются подписчику
    fun getReplayNumbers(){

        // Создаём "горячий" генератор данных
        val observable = Observable
            .intervalRange(1, 15, 1, 1, TimeUnit.SECONDS)
            .map { it.toString() }
            .replay()

        // Стартуем поток
        observable.connect()

        // Первый подписчик подписывается через 2 секунды
        Handler().postDelayed(Runnable {
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setReplayLeftNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 2000)

        // Второй подписчик подписывается через 5,5 секунд
        Handler().postDelayed(Runnable {
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setReplayRightNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 5500)
    }

    // В момент первой подписки стартует "горячий" поток и все последующие подписчики
    // получают элементы потока с момента подписки
    fun getRefCountNumbers(){

        var leftDisposable : Disposable? = null
        var rightDisposable : Disposable? = null

        // Создаём "горячий" генератор данных
        val observable = Observable
            .intervalRange(1, 15, 1, 1, TimeUnit.SECONDS)
            .map { it.toString() }
            .publish()
            .refCount()

        // Первый подписчик подписывается через 1 секунду
        Handler().postDelayed(Runnable {
            leftDisposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setRefCountLeftNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 1000)

        // Второй подписчик подписывается через 3,5 секунды
        Handler().postDelayed(Runnable {
            rightDisposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setRefCountRightNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 3500)

        // Первый подписчик отписывается через 5,5 секунд
        Handler().postDelayed(Runnable {
            leftDisposable?.dispose()
        }, 7500)

        // Второй подписчик отписывается через 7 секунд
        Handler().postDelayed(Runnable {
            rightDisposable?.dispose()
        }, 10000)

        // Первый подписчик снова подписывается через 9,5 секунд
        Handler().postDelayed(Runnable {
            leftDisposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setRefCountLeftNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 12500)
    }

    // В момент первой подписки стартует "горячий" поток но все последующие подписчики
    // в момент подписки сначала получают все пропущенные элементы
    fun getCacheNumbers(){

        var leftDisposable : Disposable? = null
        var rightDisposable : Disposable? = null

        // Создаём "горячий" генератор данных
        val observable = Observable
            .intervalRange(1, 15, 1, 1, TimeUnit.SECONDS)
            .map { it.toString() }
            .cache()

        // Первый подписчик подписывается через 1 секунду
        Handler().postDelayed(Runnable {
            leftDisposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setCacheLeftNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 1000)

        // Второй подписчик подписывается через 3,5 секунды
        Handler().postDelayed(Runnable {
            rightDisposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setCacheRightNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 3500)

        // Первый подписчик отписывается через 5,5 секунд
        Handler().postDelayed(Runnable {
            leftDisposable?.dispose()
        }, 7500)

        // Второй подписчик отписывается через 7 секунд
        Handler().postDelayed(Runnable {
            rightDisposable?.dispose()
        }, 10000)

        // Первый подписчик снова подписывается через 9,5 секунд
        Handler().postDelayed(Runnable {
            leftDisposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    viewState.setCacheLeftNumbers(it)
                }
                .addTo(CompositeDisposable())
        }, 12500)
    }
}