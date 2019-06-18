package ru.eyelog.rxgames.module002

import android.os.Bundle
import android.widget.ArrayAdapter
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_module_001.*
import kotlinx.android.synthetic.main.activity_module_002.*
import ru.eyelog.rxgames.R

class Module002Activity : MvpAppCompatActivity(), Module002View{

    @InjectPresenter
    lateinit var module002ViewModel: Module002ViewModel

    val numbersLeft = ArrayList<String>()
    val numbersRight = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_002)

        btCold.setOnClickListener {
            numbersLeft.clear()
            numbersRight.clear()
            module002ViewModel.getColdNumbers()
        }

        btHot.setOnClickListener {
            numbersLeft.clear()
            numbersRight.clear()
            module002ViewModel.getHotNumbers()
        }

        btReplay.setOnClickListener {
            numbersLeft.clear()
            numbersRight.clear()
            module002ViewModel.getReplayNumbers()
        }

        btRefCount.setOnClickListener {
            numbersLeft.clear()
            numbersRight.clear()
            module002ViewModel.getRefCountNumbers()
        }

        btCache.setOnClickListener {
            numbersLeft.clear()
            numbersRight.clear()
            module002ViewModel.getCacheNumbers()
        }
    }

    override fun setColdLeftNumbers(numberLeft: String) {
        leftListAdapter(numberLeft)
    }

    override fun setColdRightNumbers(numberRight: String) {
        rightListAdapter(numberRight)
    }

    override fun setHotLeftNumbers(numberLeft: String) {
        leftListAdapter(numberLeft)
    }

    override fun setHotRightNumbers(numberRight: String) {
        rightListAdapter(numberRight)
    }

    override fun setReplayLeftNumbers(numberLeft: String) {
        leftListAdapter(numberLeft)
    }

    override fun setReplayRightNumbers(numberRight: String) {
        rightListAdapter(numberRight)
    }

    override fun setRefCountLeftNumbers(numberLeft: String) {
        leftListAdapter(numberLeft)
    }

    override fun setRefCountRightNumbers(numberRight: String) {
        rightListAdapter(numberRight)
    }

    override fun setCacheLeftNumbers(numberLeft: String) {
        leftListAdapter(numberLeft)
    }

    override fun setCacheRightNumbers(numberRight: String) {
        rightListAdapter(numberRight)
    }

    private fun leftListAdapter(numberLeft: String){
        numbersLeft.add(numberLeft)
        val adapterLeft = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbersLeft
        )
        listViewLeft.adapter = adapterLeft
        listViewLeft.setSelection(numbersLeft.size -1)
    }

    private fun rightListAdapter(numberRight: String){
        numbersRight.add(numberRight)
        val adapterRight = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbersRight
        )
        listViewRight.adapter = adapterRight
        listViewRight.setSelection(numbersRight.size -1)
    }
}