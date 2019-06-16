package ru.eyelog.rxgames.module002

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.eyelog.rxgames.R

class Module002Activity : MvpAppCompatActivity(), Module002View{

    @InjectPresenter
    lateinit var module002ViewModel: Module002ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_001)

//        btRun.setOnClickListener {
//            module001ViewModel.getRandomNumbers()
//        }
//
//        btRange.setOnClickListener {
//            module001ViewModel.getRangeNumbers()
//        }
//
//        btInterval.setOnClickListener {
//            module001ViewModel.getIntervalNumbers()
//        }
    }

}