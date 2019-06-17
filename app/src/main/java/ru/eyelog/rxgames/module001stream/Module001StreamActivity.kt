package ru.eyelog.rxgames.module001stream

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_module_001.*
import ru.eyelog.rxgames.R
import android.widget.ArrayAdapter

class Module001StreamActivity : MvpAppCompatActivity(), Module001StreamView{

    @InjectPresenter
    lateinit var module001SingleViewModel: Module001StreamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_001)

        btRun.setOnClickListener {
            module001SingleViewModel.getRandomNumbers()
        }

        btRange.setOnClickListener {
            module001SingleViewModel.getRangeNumbers()
        }

        btInterval.setOnClickListener {
            module001SingleViewModel.getIntervalNumbers()
        }

        btFromCallable.setOnClickListener {
            module001SingleViewModel.getFromCallableNumbers()
        }

        btMap.setOnClickListener {
            module001SingleViewModel.getMapNumbers()
        }

        btBuffer.setOnClickListener {
            module001SingleViewModel.getBufferNumbers()
        }
    }

    override fun setRandomNumbers(numbers: List<Int>) {
        val adapter = ArrayAdapter<Int>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setRangeNumbers(numbers: List<Int>) {
        val adapter = ArrayAdapter<Int>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setIntervalNumbers(numbers: List<Int>) {
        val adapter = ArrayAdapter<Int>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setFromCallableNumbers(numbers: List<Int>) {
        val adapter = ArrayAdapter<Int>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setMapNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setBufferNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }
}