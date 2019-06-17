package ru.eyelog.rxgames.module001stream

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.eyelog.rxgames.utils.MockNumbers
import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit


@InjectViewState
class Module001StreamViewModel : MvpPresenter<Module001StreamView>() {

    // Просто генерим рандомный список чисел
    @SuppressLint("CheckResult")
    fun getRandomNumbers() {

        Observable.create(ObservableOnSubscribe<List<Int>>
        { emitter -> emitter.onNext(MockNumbers.generateList()) })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result -> viewState.setRandomNumbers(result) }
    }

    // Числа по порядку
    @SuppressLint("CheckResult")
    fun getRangeNumbers() {
        val list = ArrayList<Int>()

        Observable.range(10, 15)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                list.add(result)
                viewState.setRangeNumbers(list)
            }
    }

    // Числа по порядку с задержкой
    @SuppressLint("CheckResult")
    fun getIntervalNumbers() {
        val list = ArrayList<Int>()

        Observable.intervalRange(1, 30, 1, 1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                list.add(result.toInt())
                viewState.setIntervalNumbers(list)
            }
    }

    // Ожидаем выпуска числа
    fun getFromCallableNumbers() {
        val list = ArrayList<Int>()

        Single.fromCallable(CallableLongAction("5"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterSuccess {
                list.add(it)
                viewState.setFromCallableNumbers(list)
            }
            .subscribe()
    }

    private fun longAction(text: String): Int {
        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return Integer.parseInt(text)
    }

    internal inner class CallableLongAction(private val data: String) : Callable<Int> {
        @Throws(Exception::class)
        override fun call(): Int? {
            return longAction(data)
        }
    }

    // Преобразовываем Int в String с помощью map
    @SuppressLint("CheckResult")
    fun getMapNumbers() {
        val list = ArrayList<String>()

        Observable.intervalRange(1, 12, 1, 1, TimeUnit.SECONDS)
            .map { "Number $it" }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                list.add(result)
                viewState.setMapNumbers(list)
            }
    }

    // С помощью команды buffer фасуем данные из общего списка
    @SuppressLint("CheckResult")
    fun getBufferNumbers() {
        val list = ArrayList<String>()

        val observable = Observable
            .fromIterable(MockNumbers.generateList())
            .buffer(3)
            .map { it.toString() }
            .doOnNext { list.add(it) }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewState.setBufferNumbers(list)
            }
    }
}
