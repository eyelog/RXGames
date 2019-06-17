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
//            module001SingleViewModel.getRandomNumbers()
//        }
//
//        btRange.setOnClickListener {
//            module001SingleViewModel.getRangeNumbers()
//        }
//
//        btInterval.setOnClickListener {
//            module001SingleViewModel.getIntervalNumbers()
//        }
    }

}