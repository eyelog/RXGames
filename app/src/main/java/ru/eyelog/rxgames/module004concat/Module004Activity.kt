package ru.eyelog.rxgames.module004concat

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_module_004.*
import ru.eyelog.rxgames.R

class Module004Activity : MvpAppCompatActivity(), Module004View {

    @InjectPresenter
    lateinit var presenter: Module004Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_003)

        btSimple.setOnClickListener {

        }

    }
}