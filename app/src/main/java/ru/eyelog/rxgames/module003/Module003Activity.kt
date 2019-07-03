package ru.eyelog.rxgames.module003

import android.os.Bundle
import android.widget.ArrayAdapter
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_module_003.*
import ru.eyelog.rxgames.R
import ru.eyelog.rxgames.utils.ObjOutCome

class Module003Activity : MvpAppCompatActivity(), Module003View{

    @InjectPresenter
    lateinit var module003Presenter: Module003Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_003)

        btFlatMap.setOnClickListener {
            module003Presenter.getFlatMapNumbers()
        }

        btFlatMapList.setOnClickListener {
            module003Presenter.getFlatMapListNumbers()
        }

        btIncomeObj.setOnClickListener {
            module003Presenter.getObjectNumbers()
        }

        btOutcomeObj.setOnClickListener {
            module003Presenter.getObjectNumbers()
        }

        btFlatMapTwoLists.setOnClickListener {
            module003Presenter.getFlatMapTwoListsNumbers()
        }
    }

    override fun setFlatMapNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setOutcomeObject(obj: ObjOutCome) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, obj.numbers
        )
        listView.adapter = adapter
    }

    override fun setFlatMapListNumbers(numbers: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView.adapter = adapter
    }

    override fun setFlatMapTwoListsNumbers(numbers: List<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}