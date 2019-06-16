package ru.eyelog.rxgames.module001

import android.os.Bundle
import android.os.PersistableBundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_module_001.*
import ru.eyelog.rxgames.R
import android.widget.ArrayAdapter
import android.widget.ListAdapter

class Module001Activity : MvpAppCompatActivity(), Module001View{

    @InjectPresenter
    lateinit var module001ViewModel: Module001ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_001)

        btRun.setOnClickListener {
            module001ViewModel.getRandomNumbers()
        }

        btRange.setOnClickListener {
            module001ViewModel.getRangeNumbers()
        }

        btInterval.setOnClickListener {
            module001ViewModel.getIntervalNumbers()
        }

        btFromCallable.setOnClickListener {
            module001ViewModel.getFromCallableNumbers()
        }

        btMap.setOnClickListener {
            module001ViewModel.getMapNumbers()
        }

        btBuffer.setOnClickListener {
            module001ViewModel.getBufferNumbers()
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