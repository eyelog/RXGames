package ru.eyelog.rxgames.module001single

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import ru.eyelog.rxgames.utils.MockNumbers
import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

@InjectViewState
class Module001SingleViewModel : MvpPresenter<Module001SingleView>() {

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

    // Ожидаем выпуска данных
    fun getFromCallableNumbers() {
        val list = ArrayList<Int>()

        Single.fromCallable(CallableLongAction())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterSuccess {
                list.addAll(it)
                viewState.setFromCallableNumbers(list)
            }
            .subscribe()
    }

    internal inner class CallableLongAction : Callable<List<Int>> {
        @Throws(Exception::class)
        override fun call(): List<Int>? {
            return longAction()
        }
    }

    private fun longAction(): List<Int> {
        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return MockNumbers.generateList()
    }

    // Преобразовываем Int в String с помощью map
    @SuppressLint("CheckResult")
    fun getMapNumbers() {
        val list = ArrayList<String>()

        val observable = Observable
            .fromIterable(MockNumbers.generateList())
            .map(mapperIntToString)
//            .map { "Number $it" }
            .doOnNext { list.add(it) }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewState.setBufferNumbers(list)
            }
    }

    private val mapperIntToString = Function<Int, String>{ "Number $it" }

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

    // Выбор 3-х первых чисел из списка
    @SuppressLint("CheckResult")
    fun getTakeNumbers(){
        val list = ArrayList<String>()

        val observable = Observable
            .fromIterable(MockNumbers.generateList())
            .take(3)
            .map { it.toString() }
            .doOnNext { list.add(it) }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewState.setTakeNumbers(list)
            }
    }

    // Пропускаем первые 3 числа
    @SuppressLint("CheckResult")
    fun getSkipNumbers(){
        val list = ArrayList<String>()

        val observable = Observable
            .fromIterable(MockNumbers.generateList())
            .skip(3)
            .map { it.toString() }
            .doOnNext { list.add(it) }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewState.setSkipNumbers(list)
            }
    }

    // Отсеиваем дубликаты
    @SuppressLint("CheckResult")
    fun getDistinctNumbers(){
        val list = ArrayList<String>()

        val observable = Observable
            .fromIterable(MockNumbers.generateList())
            .distinct()
            .map { it.toString() }
            .doOnNext { list.add(it) }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewState.setDistinctNumbers(list)
            }
    }

    // Отсеиваем фильтруем по значению
    @SuppressLint("CheckResult")
    fun getFilterNumbers(){
        val list = ArrayList<String>()

        val observable = Observable
            .fromIterable(MockNumbers.generateList())
            .map { it.toString() }
            .filter { it.contains("5") }
            .doOnNext { list.add(it) }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewState.setFilterNumbers(list)
            }
    }

    // Соединяем последовательно два потока
    @SuppressLint("CheckResult")
    fun getMergeNumbers(){
        val list = ArrayList<String>()

        val observableFirst = Observable
            .fromIterable(MockNumbers.generateList())

        val observable = Observable
            .fromIterable(MockNumbers.generateList())
            .mergeWith(observableFirst)
            .map { it.toString() }
            .doOnNext { list.add(it) }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewState.setMergeNumbers(list)
            }
    }

    // Совмещаем два потока в пример
    @SuppressLint("CheckResult")
    fun getZipNumbers(){
        val list = ArrayList<String>()

        val observableFirst = Observable
            .fromIterable(MockNumbers.generateList())

        val observable = Observable
            .fromIterable(MockNumbers.generateList())
            .zipWith(observableFirst, zipMapper)
            .doOnNext { list.add(it) }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewState.setZipNumbers(list)
            }
    }

    private val zipMapper = BiFunction<Int, Int, String>{ f1, f2 ->
        "$f1 + $f2 = ${f1 + f2}"
    }

    // Пропускаем поток, пока не встретиться цифра 5
    @SuppressLint("CheckResult")
    fun getTakeUntilNumbers(){
        val list = ArrayList<String>()

        val observable = Observable
            .fromIterable(MockNumbers.generateList())
            .map { it.toString() }
            .takeUntil { it.contains("5") }
            .doOnNext { list.add(it) }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewState.setTakeUntilNumbers(list)
            }
    }

    // Просто проверка, есть ли в списке число больше 150-ти?
    @SuppressLint("CheckResult")
    fun getAllNumbers(){
        val list = ArrayList<String>()

        val observable = Observable
            .fromIterable(MockNumbers.generateList())
            .all{ it > 150 }
            .doOnSuccess {
                list.add("got")
            }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterSuccess {
                viewState.setAllNumbers(list)
            }
            .subscribe()
    }
}
