package ru.eyelog.rxgames.module001single

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_module_001.*
import ru.eyelog.rxgames.R
import android.widget.ArrayAdapter

class Module001SingleActivity : MvpAppCompatActivity(), Module001SingleView{

    @InjectPresenter
    lateinit var module001SinglePresenter: Module001SinglePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_001)

        btRun.setOnClickListener {
            module001SinglePresenter.getRandomNumbers()
        }

        btRange.setOnClickListener {
            module001SinglePresenter.getRangeNumbers()
        }

        btInterval.setOnClickListener {
            module001SinglePresenter.getIntervalNumbers()
        }

        btFromCallable.setOnClickListener {
            module001SinglePresenter.getFromCallableNumbers()
        }

        btMap.setOnClickListener {
            module001SinglePresenter.getMapNumbers()
        }

        btBuffer.setOnClickListener {
            module001SinglePresenter.getBufferNumbers()
        }

        btTake.setOnClickListener {
            module001SinglePresenter.getTakeNumbers()
        }

        btSkip.setOnClickListener {
            module001SinglePresenter.getSkipNumbers()
        }

        btDistinct.setOnClickListener {
            module001SinglePresenter.getDistinctNumbers()
        }

        btFilter.setOnClickListener {
            module001SinglePresenter.getFilterNumbers()
        }

        btMerge.setOnClickListener {
            module001SinglePresenter.getMergeNumbers()
        }

        btZip.setOnClickListener {
            module001SinglePresenter.getZipNumbers()
        }

        btTakeUntil.setOnClickListener {
            module001SinglePresenter.getTakeUntilNumbers()
        }

        btAll.setOnClickListener {
            module001SinglePresenter.getAllNumbers()
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

    override fun setTakeNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setSkipNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setDistinctNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setFilterNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setMergeNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setZipNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setTakeUntilNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setAllNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }
}